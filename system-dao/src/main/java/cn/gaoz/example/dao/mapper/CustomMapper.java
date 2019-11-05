package cn.gaoz.example.dao.mapper;

import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * 动态SQL的mapper类
 * Mapper接口：基本的增、删、改、查方法
 *
 * @author gaoz
 */
@Repository
public interface CustomMapper {
    Integer insert(String statement);

    Integer delete(String statement);

    Integer update(String statement);

    List<Map<String, Object>> select(String statement);

    Integer selectCount(String statement);
}
