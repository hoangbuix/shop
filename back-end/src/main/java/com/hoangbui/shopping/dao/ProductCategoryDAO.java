package com.hoangbui.shopping.dao;

import org.springframework.stereotype.Repository;

@Repository
public interface ProductCategoryDAO<E> extends CommonDAO<E> {
  E findByProductIdAndCategoryId(int productId, int categoryId);
}
