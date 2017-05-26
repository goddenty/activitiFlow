package com.perkins.dao.mapper;

import java.util.List;

import com.github.abel533.mapper.Mapper;
import com.perkins.entity.Role;

public interface RoleMapper extends Mapper<Role> {
    /**
     * 根据用户名查询用户所属角色
     * @param userId
     * @return
     */
    List<Role> findRoleByUser(String userId);
}