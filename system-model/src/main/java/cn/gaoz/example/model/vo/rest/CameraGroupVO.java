package cn.gaoz.example.model.vo.rest;

import cn.gaoz.example.dao.po.Camera;
import cn.gaoz.example.dao.po.Cameragroup;

import java.util.List;

public class CameraGroupVO extends Cameragroup {
    private List<CameraGroupVO> childGroups;
    private List<Camera> childCameras;

    public List<CameraGroupVO> getChildGroups() {
        return childGroups;
    }

    public void setChildGroups(List<CameraGroupVO> childGroups) {
        this.childGroups = childGroups;
    }

    public List<Camera> getChildCameras() {
        return childCameras;
    }

    public void setChildCameras(List<Camera> childCameras) {
        this.childCameras = childCameras;
    }

    public void Clone(Cameragroup cameragroup) {
        super.setCreatetime(cameragroup.getCreatetime());
        super.setId(cameragroup.getId());
        super.setName(cameragroup.getName());
        super.setParentgroupid(cameragroup.getParentgroupid());
        super.setPlatformid(cameragroup.getPlatformid());
    }
}
