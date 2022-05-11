package com.hoangbui.shopping.service;

import com.hoangbui.shopping.entity.NotificationEntity;
import com.hoangbui.shopping.entity.PostEntity;
import com.hoangbui.shopping.model.req.update.UpdateNotificationReq;
import com.hoangbui.shopping.util.NotificationName;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface NotificationService {

    void create(int userId, PostEntity post, NotificationName notificationName);

    NotificationEntity update(UpdateNotificationReq req);

    List<NotificationEntity> getNotificationByEmail(String email, boolean screen);

    NotificationEntity sendNotification(int id);
}
