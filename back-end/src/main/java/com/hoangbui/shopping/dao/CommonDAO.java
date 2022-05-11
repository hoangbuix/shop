package com.hoangbui.shopping.dao;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
public interface CommonDAO<E> extends BaseDAO<E> {
    @Transactional
    int save(E instance);

    @Transactional
    void update(E instance);

    @Transactional
    void delete(int id);

    List<E> findAll();

    E findById(int id);
}