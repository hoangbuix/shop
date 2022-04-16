package com.hoangbui.shopping.service;

import com.hoangbui.shopping.entity.UserEntity;
import com.hoangbui.shopping.model.req.create.CreateUserReq;
import com.hoangbui.shopping.model.req.update.ChangePasswordReq;
import com.hoangbui.shopping.model.req.update.UpdateUserReq;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {
    UserEntity save(CreateUserReq req);

    UserEntity update(UserEntity user, UpdateUserReq req);

    void changePassword(UserEntity user, ChangePasswordReq req);

    List<UserEntity> findAll();

    UserEntity findById(int id);

    boolean activateUser(String code);

    void sendMessage(UserEntity user);
}
