package com.hoangbui.shopping.dao;

import org.springframework.stereotype.Repository;

@Repository
public interface ProductDAO<E> extends CommonDAO<E> {
    int checkTotalProduct();
}
