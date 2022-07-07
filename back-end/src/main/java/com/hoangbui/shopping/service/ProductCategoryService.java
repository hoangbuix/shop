package com.hoangbui.shopping.service;

import com.hoangbui.shopping.entity.ProductCategoryEntity;
import com.hoangbui.shopping.model.req.create.CreateProductCategoryReq;
import com.hoangbui.shopping.model.req.update.UpdateProductCategoryReq;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProductCategoryService {
    ProductCategoryEntity save(CreateProductCategoryReq req);

    ProductCategoryEntity update(UpdateProductCategoryReq req);

    void delete(int id);

    ProductCategoryEntity findById(int id);

    ProductCategoryEntity findByProductIdAndCategoryId(int productId, int categoryId);

    List<ProductCategoryEntity> findAll();
}
