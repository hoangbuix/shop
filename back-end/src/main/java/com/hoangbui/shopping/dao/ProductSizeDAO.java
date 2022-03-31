package com.hoangbui.shopping.dao;

import org.springframework.stereotype.Repository;

@Repository
public interface ProductSizeDAO<E> extends CommonDAO<E> {
    E findBySize(String size);
    E findByQuantity(String quantity);
    E findByGender(String gender);
    E findBySizeCodeAndGender(String sizeCode, String gender);
}
