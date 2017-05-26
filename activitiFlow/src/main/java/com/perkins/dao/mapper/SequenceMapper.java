package com.perkins.dao.mapper;

import org.apache.ibatis.annotations.Param;

/**
 * Created by wangkang on 2017/5/17.
 * oracle 获取Sequence值的mapper类
 */
public interface SequenceMapper {

    public Long getNextValue(@Param("sequenceName") String sequenceName);

    public Long getCurrentValue(@Param("sequenceName") String sequenceName);

}
