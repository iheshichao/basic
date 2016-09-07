package cn.lingban.dubbo.common;

import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

/**
 * Created by heshichao on 16-9-7.
 */
public interface BasicMapper<T> extends Mapper<T>, MySqlMapper<T> {
}
