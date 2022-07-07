package com.hoangbui.shopping.dao.impl;

import com.hoangbui.shopping.dao.UserRoleDAO;
import com.hoangbui.shopping.entity.UserRoleEntity;
import com.hoangbui.shopping.model.mapper.UserRoleMapper;
import com.hoangbui.shopping.util.QueryConstant;
import com.hoangbui.shopping.util.SqlConstant;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
@Transactional(rollbackFor = Exception.class)
public class UserRoleDAOImpl extends BaseDAOImpl<UserRoleEntity> implements UserRoleDAO<UserRoleEntity> {
    private final String USER_ROLE = "userRole";

    @Override
    public int save(UserRoleEntity userRole) {
        return insert(QueryConstant.callQuery(USER_ROLE, SqlConstant.CREATE, userRole.getUsers().getId(),
                userRole.getRoles().getId()), userRole.getUsers().getId(),
                userRole.getRoles().getId());
    }

    @Override
    public void update(UserRoleEntity userRole) {
        update(QueryConstant.callQuery(USER_ROLE, SqlConstant.UPDATE, userRole.getUsers().getId(),
                userRole.getRoles().getId()), userRole.getUsers().getId(),
                userRole.getRoles().getId(), userRole.getActiveFlag());
    }

    @Override
    public void delete(int id) {
        delete(QueryConstant.callQuery(USER_ROLE, SqlConstant.DELETE, id), id);
    }

    @Override
    public List<UserRoleEntity> findAll() {
        return query(QueryConstant.callQuery(USER_ROLE, SqlConstant.FIND_ALL, ""), new UserRoleMapper());
    }

    @Override
    public UserRoleEntity findById(int id) {
        List<UserRoleEntity> userRole = query(QueryConstant.callQuery(USER_ROLE, SqlConstant.FIND_BY_ID, id), new UserRoleMapper(), id);
        return userRole.isEmpty() ? null : userRole.get(0);
    }
}