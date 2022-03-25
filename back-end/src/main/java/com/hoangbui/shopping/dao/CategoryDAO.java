package com.hoangbui.shopping.dao;

import org.springframework.stereotype.Repository;

@Repository
public interface CategoryDAO<E> extends CommonDAO<E> {
    E findByCode(String code);
}
