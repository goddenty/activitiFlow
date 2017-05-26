package com.perkins.service.impl;

import java.util.List;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.github.abel533.mapper.Mapper;
import com.github.abel533.mapperhelper.EntityHelper;
import com.perkins.dao.mapper.SequenceMapper;
import com.perkins.entity.IDEntity;
import com.perkins.service.IBaseService;
import com.perkins.util.BeanGenericUtil;

public abstract class BaseService<T extends IDEntity, M extends Mapper<T>> implements IBaseService<T, M> {

    protected Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    protected M mapper;

    @Autowired
    protected SequenceMapper sequenceMapper;

    public List<T> select(T record) {
        return mapper.select(record);
    }

    @SuppressWarnings("unchecked")
    public List<T> selectAll() {
        try {
            return select((T) BeanGenericUtil.getGenericClass(getClass()).newInstance());
        } catch (InstantiationException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

    public T selectOne(T record) {
        return mapper.selectOne(record);
    }

    public T selectOneOnly(T record) {
        List<T> list = select(record);
        if (list == null || list.size() == 0) {
            return null;
        }
        return list.get(0);
    }

    public int selectCount(T record) {
        return mapper.selectCount(record);
    }

    public T selectByPrimaryKey(Object key) {
        return mapper.selectByPrimaryKey(key);
    }

    /**
     * 根据id进行更新或者插入操作
     *
     * @param record
     * @return
     */
    public int saveOrUpdate(T record) {
        if (record.getId() == null) {
            return insert(record);
        } else {
            return updateByPrimaryKeySelective(record);
        }
    }

    public int insert(T record) {
        int ret = mapper.insert(record);
        // 回写主键id Sequence值
        returnId(record);
        return ret;
    }

    public int insertSelective(T record) {
        int ret = mapper.insertSelective(record);
        // 回写主键id Sequence值
        returnId(record);
        return ret;
    }

    /**
     * // 回写主键id Sequence值 解决mapper不返回oracle id值问题
     * // 处理单一主键
     *
     * @param record
     * @return
     */
    protected void returnId(T record) {
        //获取全部列
        Set<EntityHelper.EntityColumn> columnList = EntityHelper.getColumns(BeanGenericUtil.getGenericClass(getClass()));
        //处理所有的主键策略
        for (EntityHelper.EntityColumn column : columnList) {
            //序列的情况，直接写入sql中，不需要额外的获取值
            if (column.getSequenceName() != null && column.getSequenceName().length() > 0) {
                record.setId(sequenceMapper.getCurrentValue(column.getSequenceName()));
                break;
            }
        }
    }

    public int delete(T record) {
        return mapper.delete(record);
    }

    public int deleteByPrimaryKey(Object key) {
        return mapper.deleteByPrimaryKey(key);
    }

    public int updateByPrimaryKey(T record) {
        return mapper.updateByPrimaryKey(record);
    }

    public int updateByPrimaryKeySelective(T record) {
        return mapper.updateByPrimaryKeySelective(record);
    }

    public int selectCountByExample(Object example) {
        return mapper.selectCountByExample(example);
    }

    public int deleteByExample(Object example) {
        return mapper.deleteByExample(example);
    }

    public List<T> selectByExample(Object example) {
        return mapper.selectByExample(example);
    }

    public int updateByExampleSelective(T record, Object example) {
        return mapper.updateByExampleSelective(record, example);
    }

    public int updateByExample(T record, Object example) {
        return mapper.updateByExample(record, example);
    }

}
