package cn.gaoz.example.impl;

import cn.gaoz.example.CameraGroupService;
import cn.gaoz.example.ListUtil;
import cn.gaoz.example.StringUtil;
import cn.gaoz.example.dao.mapper.CameraMapper;
import cn.gaoz.example.dao.mapper.CameragroupMapper;
import cn.gaoz.example.dao.po.Camera;
import cn.gaoz.example.dao.po.Cameragroup;
import cn.gaoz.example.model.vo.rest.CameraGroupVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class CameraGroupServiceImpl implements CameraGroupService {
    @Resource
    private CameragroupMapper cameragroupMapper;
    @Resource
    private CameraMapper cameraMapper;
    private final Logger logger = LoggerFactory.getLogger(CameraGroupServiceImpl.class);

    @Override
    public Integer createOne(Cameragroup cameragroup) {
        Integer result = -1;
        try {
            cameragroup.setCreatetime(new Date());
            if (this.cameragroupMapper.insert(cameragroup) > 0) {
                result = cameragroup.getId();
            }
        } catch (Exception e) {
            this.logger.error("createOne 异常", e);
        }
        return result;
    }

    @Override
    public boolean updateOne(Cameragroup cameragroup) {
        boolean result = false;
        try {
            result = this.cameragroupMapper.updateByPrimaryKey(cameragroup) > 0;
        } catch (Exception e) {
            this.logger.error("updateOne 异常", e);
        }
        return result;
    }

    @Override
    public boolean deleteOne(Integer id) {
        boolean result = false;
        try {
            result = this.cameragroupMapper.deleteByPrimaryKey(id) > 0;
        } catch (Exception e) {
            this.logger.error("deleteOne 异常", e);
        }
        return result;
    }

    @Override
    public boolean deleteBatch(List<Integer> ids) {
        boolean result = false;
        try {
            Example example = new Example(Cameragroup.class);
            Example.Criteria criteria = example.createCriteria();
            criteria.andIn("id", ids);
            result = this.cameragroupMapper.deleteByExample(example) > 0;
        } catch (Exception e) {
            this.logger.error("deleteBatch 异常", e);
        }
        return result;
    }

    @Override
    public Cameragroup getOne(Integer id) {
        Cameragroup result = null;
        try {
            result = this.cameragroupMapper.selectByPrimaryKey(id);
        } catch (Exception e) {
            this.logger.error("getOne 异常", e);
        }
        return result;
    }

    @Override
    public List<Cameragroup> getList(Integer platformId, Integer parentGroupId, String name) {
        List<Cameragroup> result = null;
        try {
            Example example = new Example(Cameragroup.class);
            Example.Criteria criteria = example.createCriteria();
            if (platformId != null) {
                criteria.andEqualTo("platformid", platformId);
            }
            if (parentGroupId != null) {
                criteria.andEqualTo("parentgroupid", parentGroupId);
            }
            if (StringUtil.isNotEmpty(name)) {
                criteria.andEqualTo("name", name);
            }
            result = this.cameragroupMapper.selectByExample(example);
        } catch (Exception e) {
            this.logger.error("getList 异常", e);
        }
        return result;
    }

    @Override
    public List<CameraGroupVO> getTree() {
        List<CameraGroupVO> result = null;
        try {
            List<Cameragroup> cameragroupDBList = this.cameragroupMapper.selectAll();
            if (ListUtil.isEmpty(cameragroupDBList)) {
                return result;
            }

            List<Camera> cameraDBList = this.cameraMapper.selectAll();
            result = this.getCameraGroupVO(0, cameragroupDBList, cameraDBList);
        } catch (Exception e) {
            this.logger.error("getTree 异常", e);
        }
        return result;
    }

    @Override
    public List<CameraGroupVO> getStepGroup(Integer id) {
        List<CameraGroupVO> result = null;
        try {
            Example example = new Example(Cameragroup.class);
            Example.Criteria criteria = example.createCriteria();
            criteria.andEqualTo("parentgroupid", id);
            List<Cameragroup> cameragroupDBList = this.cameragroupMapper.selectByExample(example);
            if (ListUtil.isNotEmpty(cameragroupDBList)) {
                result = new ArrayList<CameraGroupVO>();
                for (Cameragroup cameragroup : cameragroupDBList) {
                    CameraGroupVO cameraGroupVO = new CameraGroupVO();
                    cameraGroupVO.Clone(cameragroup);
                    result.add(cameraGroupVO);
                }
            }
        } catch (Exception e) {
            this.logger.error("getStepGroup 异常", e);
        }
        return result;
    }

    @Override
    public List<Camera> getStepCamera(Integer id) {
        List<Camera> result = null;
        try {
            Example example = new Example(Camera.class);
            Example.Criteria criteria = example.createCriteria();
            criteria.andEqualTo("groupid", id);
            result = this.cameraMapper.selectByExample(example);
        } catch (Exception e) {
            this.logger.error("getStepCamera 异常", e);
        }
        return result;
    }

    //region private methods

    private List<CameraGroupVO> getCameraGroupVO(Integer parentId, List<Cameragroup> cameragroupList, List<Camera> cameraList) {
        List<CameraGroupVO> result = new ArrayList<CameraGroupVO>();
        try {
            for (Cameragroup cameragroup : cameragroupList) {
                if (cameragroup.getParentgroupid().equals(parentId)) {
                    CameraGroupVO cameraGroupVO = new CameraGroupVO();
                    cameraGroupVO.Clone(cameragroup);
                    Integer tempId = cameraGroupVO.getId();
                    cameraGroupVO.setChildGroups(this.getCameraGroupVO(tempId, cameragroupList, cameraList));
                    if (ListUtil.isNotEmpty(cameraList)) {
                        List<Camera> tempChildCameras = new ArrayList<Camera>();
                        for (Camera camera : cameraList) {
                            Integer groupId = camera.getGroupid();
                            if (groupId != null && groupId.equals(tempId)) {
                                tempChildCameras.add(camera);
                            }
                        }
                        cameraGroupVO.setChildCameras(tempChildCameras);
                    }
                    result.add(cameraGroupVO);
                }
            }
        } catch (Exception e) {
            this.logger.error("getCameraGroupVO 异常", e);
        }
        return result;
    }

    //endregion

    //region public methods

    public boolean deleteByPlatformId(Integer platformId) {
        boolean result = false;
        try {
            if (platformId == null) {
                this.logger.warn("deleteByPlatformId 参数为空");
                return result;
            }

            List<Cameragroup> cameragroupDBList = this.getList(platformId, null, null);
            if (ListUtil.isNotEmpty(cameragroupDBList)) {
                List<Integer> tempIDList = new ArrayList<Integer>();
                for (Cameragroup cameragroupDB : cameragroupDBList) {
                    tempIDList.add(cameragroupDB.getId());
                }
                result = this.deleteBatch(tempIDList);
            } else {
                result = true;
            }
        } catch (Exception e) {
            this.logger.error("deleteByPlatformId 异常", e);
        }
        return result;
    }

    public Cameragroup getOneByPlatform(Integer platformId, String bizId) {
        Cameragroup result = null;
        try {
            Example example = new Example(Cameragroup.class);
            Example.Criteria criteria = example.createCriteria();
            criteria.andEqualTo("platformid", platformId);
            criteria.andEqualTo("bizid", bizId);
            result = this.cameragroupMapper.selectOneByExample(example);
        } catch (Exception e) {
            this.logger.error("getOneByPlatform 异常", e);
        }
        return result;
    }

    //endregion

}
