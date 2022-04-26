package com.hoangbui.shopping.dao.impl;

import com.hoangbui.shopping.dao.UserDAO;
import com.hoangbui.shopping.entity.UserEntity;
import com.hoangbui.shopping.model.mapper.UserMapper;
import com.hoangbui.shopping.util.QueryConstant;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static com.hoangbui.shopping.util.SqlConstant.*;

@Component
@Transactional(rollbackFor = Exception.class)
public class UserDAOImpl extends BaseDAOImpl<UserEntity> implements UserDAO<UserEntity> {
    final Logger log = Logger.getLogger(UserDAOImpl.class);
    private final String USER = "user";

    @Override
    public int save(UserEntity user) {
        return insert(QueryConstant.callQueryUpdate(USER, CREATE, 8), user.getFirstName(), user.getLastName(),
                user.getAvatar(), user.getUsername(), user.getPassword(), user.getEmail(),
                user.getActiveCode(), user.getActiveFlag());
    }

    @Override
    public void update(UserEntity user) {
        update(QueryConstant.callQuery(USER, UPDATE, 7), user.getFirstName(), user.getLastName(),
                user.getAvatar(), user.getUsername(), user.getPassword(), user.getEmail(), user.getActiveFlag());
    }

    @Override
    public void delete(int id) {
        delete(QueryConstant.callQueryUpdate(USER, DELETE, 1), id);
    }

    @Override
    public List<UserEntity> findAll() {
        log.info("find All");
        return query(QueryConstant.callQueryUpdate(USER, FIND_ALL, 0), new UserMapper());
    }

    @Override
    public UserEntity findById(int id) {
        List<UserEntity> users = query(QueryConstant.callQueryUpdate(USER, FIND_BY_ID, 1),
                new UserMapper(), id);
        return users.isEmpty() ? null : users.get(0);
    }

    @Override
    public UserEntity findByUsernameOrEmail(String s) {
        List<UserEntity> users = query(QueryConstant.callQueryUpdate(USER, FIND_BY_USERNAME_OR_EMAIL, 1),
                new UserMapper(), s);
        return users.isEmpty() ? null : users.get(0);
    }

    @Override
    public UserEntity findByEmail(String email) {
        List<UserEntity> users = query(QueryConstant.callQueryUpdate(USER, FIND_BY_EMAIL, 1), new UserMapper(), email);
        return users.isEmpty() ? null : users.get(0);
    }

    @Override
    public UserEntity findByActivationCode(String code) {
        List<UserEntity> users = query(QueryConstant.callQueryUpdate(USER, "_findByActivateCode", 1),
                new UserMapper(), code);
        return users.isEmpty() ? null : users.get(0);
    }

    @Override
    public UserEntity findByIdAndRole(int id) {
        List<UserEntity> users = query(QueryConstant.callQueryUpdate(USER, "_findByIdAndRole", 1), new UserMapper(), id);
        return users.isEmpty() ? null : users.get(0);
    }

    @Override
    public void updateActiveCodeAndActiveFlag(UserEntity user) {
        update(QueryConstant.callQueryUpdate(USER, "_updateActiveCodeAndActiveFlag", 2),
                user.getId(), user.getActiveFlag());
    }
}