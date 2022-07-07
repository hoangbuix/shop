package com.hoangbui.shopping.dao;

import com.hoangbui.shopping.entity.UserEntity;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostDAO<E> extends CommonDAO<E> {
    List<E> findAllByUserEmailAndDelAndApproved(String email, boolean del, boolean approve);

    List<E> findByUser(UserEntity user);
}
