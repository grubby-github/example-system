package cn.gaoz.example;

import cn.gaoz.example.dao.po.Camera;
import cn.gaoz.example.dao.po.Cameragroup;
import cn.gaoz.example.model.vo.rest.CameraGroupVO;

import java.util.List;

public interface CameraGroupService {
    Integer createOne(Cameragroup cameragroup);

    boolean updateOne(Cameragroup cameragroup);

    boolean deleteOne(Integer id);

    boolean deleteBatch(List<Integer> ids);

    Cameragroup getOne(Integer id);

    List<Cameragroup> getList(Integer platformId, Integer parentGroupId, String name);

    List<CameraGroupVO> getTree();

    List<CameraGroupVO> getStepGroup(Integer id);

    List<Camera> getStepCamera(Integer id);
}
