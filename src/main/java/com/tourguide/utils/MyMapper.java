package com.tourguide.utils;

import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

/**
 * Created by liutongbin on 2017/4/4.
 */
public interface MyMapper<T> extends Mapper<T>, MySqlMapper<T> {
}
