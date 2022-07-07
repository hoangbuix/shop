package com.hoangbui.shopping.dao;

import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NotificationDAO<E> extends CommonDAO<E> {

    List<E> findAllByUserId(int id);
}
