package com.hoangbui.shopping.entity;

import com.hoangbui.shopping.util.NotificationName;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity(name = "notification")
@Table(name = "notification")
public class NotificationEntity extends BaseEntity {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private UserEntity user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "post_id")
    private PostEntity post;

    @Column(name = "seen")
    private Boolean seen;

    //    @Column(name = "notification_name")
    @Enumerated(EnumType.STRING)
    private NotificationName notificationName;

}