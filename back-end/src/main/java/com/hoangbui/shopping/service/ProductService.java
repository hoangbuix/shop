package com.hoangbui.shopping.service;

import com.hoangbui.shopping.entity.ProductEntity;
import com.hoangbui.shopping.model.req.create.CreateProductReq;
import com.hoangbui.shopping.model.req.update.UpdateProductReq;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProductService {
    int checkTotalProduct();

    List<ProductEntity> findAll();

    ProductEntity findById(int id);

    ProductEntity save(CreateProductReq req);

    ProductEntity update(UpdateProductReq req);

    void delete(int id);
}
