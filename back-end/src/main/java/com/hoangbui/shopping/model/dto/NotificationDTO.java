package com.hoangbui.shopping.model.dto;

import com.hoangbui.shopping.util.NotificationName;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class NotificationDTO {
    private Long id;

    private PostDTO postDTO;

    private boolean seen;

    private LocalDateTime createAt;

    private NotificationName notificationName;
}
