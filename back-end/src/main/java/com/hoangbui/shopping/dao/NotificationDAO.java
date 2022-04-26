package com.hoangbui.shopping.dao;

import com.hoangbui.shopping.entity.NotificationEntity;
import com.hoangbui.shopping.model.dto.NotificationDTO;
import org.springframework.stereotype.Repository;

@Repository
public interface NotificationDAO<E> {
    NotificationEntity createNotification();

    NotificationEntity getNotificationByEmail(String email, int page, boolean screen);

    NotificationDTO seenNotification(Long id);
}
