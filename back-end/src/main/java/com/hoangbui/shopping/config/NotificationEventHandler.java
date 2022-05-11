package com.hoangbui.shopping.config;

import com.hoangbui.shopping.entity.PostEntity;
import com.hoangbui.shopping.service.NotificationService;
import com.hoangbui.shopping.util.NotificationName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class NotificationEventHandler implements ApplicationListener<NotificationEvent> {
    @Autowired
    private NotificationService notificationService;

    @Override
    public void onApplicationEvent(NotificationEvent notificationEvent) {
        PostEntity post = notificationEvent.getPost();
        if (post.isApproved()) {
            notificationService.create(post.getCreatedBy(), post, NotificationName.APPROVE);
        } else {
            notificationService.create(post.getCreatedBy(), post, NotificationName.BLOCK);
        }
    }
}
