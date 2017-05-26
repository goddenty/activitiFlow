package com.perkins.service;

import java.util.List;

import com.github.abel533.mapper.Mapper;
import com.perkins.entity.IDEntity;

/**
 * Created by wangkang on 2017/5/19.
 */
public interface IBaseService<T extends IDEntity, M extends Mapper<T>> {

    public List<T> select(T record);

    public List<T> selectAll();

    public T selectOne(T record);

    public T selectOneOnly(T record);

    public int selectCount(T record);

    public T selectByPrimaryKey(Object key);

    public int saveOrUpdate(T record);

    public int insert(T record);

    public int insertSelective(T record);

    public int delete(T record);

    public int deleteByPrimaryKey(Object key);

    public int updateByPrimaryKey(T record);

    public int updateByPrimaryKeySelective(T record);

    public int selectCountByExample(Object example);

    public int deleteByExample(Object example);

    public List<T> selectByExample(Object example);

    public int updateByExampleSelective(T record, Object example);

    public int updateByExample(T record, Object example);

}
