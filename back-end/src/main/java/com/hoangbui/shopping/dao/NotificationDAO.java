package com.hoangbui.shopping.dao;

import com.hoangbui.shopping.entity.NotificationEntity;
import com.hoangbui.shopping.model.dto.NotificationDTO;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NotificationDAO<E> extends CommonDAO<E> {

    List<E> findAllByUserId(int id);
}
