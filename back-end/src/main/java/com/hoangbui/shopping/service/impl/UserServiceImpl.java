package com.hoangbui.shopping.service.impl;

import com.hoangbui.shopping.dao.RoleDAO;
import com.hoangbui.shopping.dao.UserDAO;
import com.hoangbui.shopping.dao.UserRoleDAO;
import com.hoangbui.shopping.entity.RoleEntity;
import com.hoangbui.shopping.entity.UserEntity;
import com.hoangbui.shopping.entity.UserRoleEntity;
import com.hoangbui.shopping.exception.BadRequestException;
import com.hoangbui.shopping.exception.DuplicateRecordException;
import com.hoangbui.shopping.model.conveter.UserConvert;
import com.hoangbui.shopping.model.req.create.CreateUserReq;
import com.hoangbui.shopping.model.req.update.ChangePasswordReq;
import com.hoangbui.shopping.model.req.update.UpdateUserReq;
import com.hoangbui.shopping.service.MailService;
import com.hoangbui.shopping.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.MailSender;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.util.List;

@Component
public class UserServiceImpl implements UserService {
    @Value("${hostname}")
    private String hostname;


    @Autowired
    private MailService mailService;

    @Autowired
    private UserDAO<UserEntity> userDAO;

    @Autowired
    private RoleDAO<RoleEntity> roleDAO;
    @Autowired
    private UserRoleDAO<UserRoleEntity> userRoleDAO;

    @Override
    public UserEntity save(CreateUserReq req) {
        // check exist
        UserEntity user = userDAO.findByEmail(req.getEmail());
        if (user != null) {
            throw new DuplicateRecordException("Tài khoản đã tồn tại!");
        }
        RoleEntity role = roleDAO.findByRoleName("user");
        user = UserConvert.toEntity(req);
        int id = 0;
        try {
            user.setActiveCode(role.getRoleName());
            user.setActiveFlag(1);
            id = userDAO.save(user);
            UserEntity newUser = userDAO.findById(id);
            if (id != 0) {
                UserRoleEntity userRole = new UserRoleEntity();
                userRole.setUsers(newUser);
                userRole.setRoles(role);
                userRoleDAO.save(userRole);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        sendMessage(userDAO.findById(id));
        return userDAO.findById(id);
    }

    @Override
    public UserEntity update(UserEntity user, UpdateUserReq req) {
        int id = 0;
        if (user != null) {
            user.setFirstName(req.getFirstName());
            user.setLastName(req.getLastName());
            user.setAvatar(req.getAvatar());
            user.setEmail(req.getEmail());
            id = userDAO.save(user);
        }
        return userDAO.findById(id);
    }

    @Override
    public void changePassword(UserEntity user, ChangePasswordReq req) {
        // Validate password
        if (!BCrypt.checkpw(req.getOldPassword(), user.getPassword())) {
            throw new BadRequestException("Mật khẩu cũ không chính xác");
        }
        String hash = BCrypt.hashpw(req.getNewPassword(), BCrypt.gensalt(12));
        user.setPassword(hash);
        userDAO.update(user);
    }

    @Override
    public List<UserEntity> findAll() {
        return userDAO.findAll();
    }

    @Override
    public UserEntity findById(int id) {
        return userDAO.findById(id);
    }

    @Override
    public boolean activateUser(String code) {
        UserEntity user = userDAO.findByActivationCode(code);
        if (user == null) {
            return false;
        }
        user.setActiveFlag(1);
        userDAO.update(user);
        return true;
    }

    @Override
    public void sendMessage(UserEntity user) {
        if (!StringUtils.isEmpty(user.getEmail())) {
            String message = String.format("Hello, %s! \n " +
                            "HHH." +
                            "Access link to http://%s/activate/%s",
                    user.getUsername(),
                    (hostname + "/api/v1/admin/user"),
                    user.getActiveCode()
            );
            mailService.send(user.getEmail(), "Activation code", message);
        }
    }
}
