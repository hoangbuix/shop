package com.hoangbui.shopping.service;

import com.hoangbui.shopping.entity.ProductSizeEntity;
import com.hoangbui.shopping.model.req.create.CreateProductSizeReq;
import com.hoangbui.shopping.model.req.update.UpdateProductSizeReq;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProductSizeService {
    ProductSizeEntity save(CreateProductSizeReq req);

    ProductSizeEntity update(UpdateProductSizeReq req);

    void delete(int id);

    ProductSizeEntity findById(int id);

    ProductSizeEntity findBySize(String size);

    ProductSizeEntity findByQuantity(String quantity);

    ProductSizeEntity findByGender(String gender);

    ProductSizeEntity findBySizeCodeAndGender(String sizeCode, String gender);

    List<ProductSizeEntity> findAll();
}
