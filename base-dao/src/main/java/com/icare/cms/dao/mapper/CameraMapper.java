package cn.gaoz.example.dao.mapper;

import cn.gaoz.example.dao.po.Camera;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

@Repository
public interface CameraMapper extends Mapper<Camera> {
    int updateIsOnLine (int isOnline);
}