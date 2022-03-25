package com.hoangbui.shopping.dao.impl;
import com.hoangbui.shopping.dao.RoleDAO;
import com.hoangbui.shopping.entity.RoleEntity;
import com.hoangbui.shopping.model.mapper.RoleMapper;
import com.hoangbui.shopping.util.QueryConstant;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static com.hoangbui.shopping.util.SqlConstant.FIND_BY_ROLE_NAME;

@Component
@Transactional(rollbackFor = Exception.class)
public class RoleDAOImpl extends BaseDAOImpl<RoleEntity> implements RoleDAO<RoleEntity> {
    final String ROLE = "role";

    @Override
    public RoleEntity findByRoleName(String roleName) {
        List<RoleEntity> role = query(QueryConstant.callQuery(ROLE, FIND_BY_ROLE_NAME, roleName), new RoleMapper(), roleName);
        return role.isEmpty() ? null : role.get(0);
    }
}
