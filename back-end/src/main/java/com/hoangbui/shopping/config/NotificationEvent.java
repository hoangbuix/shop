package com.hoangbui.shopping.config;

import com.hoangbui.shopping.entity.PostEntity;
import org.springframework.context.ApplicationEvent;

public class NotificationEvent extends ApplicationEvent {
    private PostEntity post;

    public NotificationEvent(Object source, PostEntity post) {
        super(source);
        this.post = post;
    }

    public PostEntity getPost() {
        return post;
    }
}
