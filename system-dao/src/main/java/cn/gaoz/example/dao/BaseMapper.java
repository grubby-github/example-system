package cn.gaoz.example.dao;

import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

/**
 * 通用mapper类
 * Mapper接口：基本的增、删、改、查方法, MySqlMapper：针对MySQL的额外补充接口，支持批量插入
 *
 * @param <T>
 * @author gaoz
 */
@Repository
public interface BaseMapper<T> extends Mapper<T>, MySqlMapper<T> {

}
