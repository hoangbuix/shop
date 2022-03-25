package com.hoangbui.shopping.dao;

import org.springframework.stereotype.Repository;

@Repository
public interface RoleDAO<E> extends BaseDAO<E> {
    E findByRoleName(String roleName);
}