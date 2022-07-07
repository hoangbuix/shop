package com.hoangbui.shopping.service.impl;

import com.hoangbui.shopping.dao.NotificationDAO;
import com.hoangbui.shopping.dao.UserDAO;
import com.hoangbui.shopping.entity.NotificationEntity;
import com.hoangbui.shopping.entity.PostEntity;
import com.hoangbui.shopping.entity.UserEntity;
import com.hoangbui.shopping.exception.NotFoundException;
import com.hoangbui.shopping.model.req.update.UpdateNotificationReq;
import com.hoangbui.shopping.service.NotificationService;
import com.hoangbui.shopping.util.NotificationName;
import lombok.RequiredArgsConstructor;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class NotificationServiceImpl implements NotificationService {
    final Logger log = Logger.getLogger(NotificationServiceImpl.class);

    @Autowired
    private NotificationDAO<NotificationEntity> notificationDAO;

    @Autowired
    private UserDAO<UserEntity> userDAO;

    @Override
    public void create(int userId, PostEntity post, NotificationName notificationName) {
        try {
            NotificationEntity notification = new NotificationEntity();
            notification.setUser(userDAO.findByIdAndRole(userId));
            notification.setPost(post);
            if (notificationName.equals(NotificationName.NOTIFICATION)) {
                notification.setNotificationName(notificationName);
                notification.setSeen(false);
            } else if (notificationName.equals(NotificationName.APPROVE)) {
                notification.setNotificationName(notificationName);
                notification.setSeen(true);
            } else {
                notification.setNotificationName(notificationName);
                notification.setSeen(true);
            }
            notificationDAO.save(notification);

        } catch (Exception e) {
            e.printStackTrace();
            log.error(e.getMessage());
        }
    }

    @Override
    public NotificationEntity update(UpdateNotificationReq req) {
        try {

        } catch (Exception e) {
            e.printStackTrace();
            log.error(e.getMessage());
        }
        return null;
    }

    @Override
    public List<NotificationEntity> getNotificationByEmail(String email, boolean screen) {
        List<NotificationEntity> notification = null;
        try {
            UserEntity user = userDAO.findByEmail(email);
            if (user != null) {
                if (screen) {
                    notification = notificationDAO.findAllByUserId(user.getId());
                } else {
                    notification = notificationDAO.findAllByUserId(user.getId());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            log.error(e.getMessage());
        }
        return notification;
    }

    @Override
    public NotificationEntity sendNotification(int id) {
        try {
            NotificationEntity notification = notificationDAO.findById(id);
            if (notification != null) {
                notification.setSeen(true);
                notificationDAO.update(notification);
                return notification;
            } else {
                throw new NotFoundException("Not found notification Id" + id);
            }

        } catch (Exception e) {
            e.printStackTrace();
            log.error(e.getMessage());
            return null;
        }
    }

}
