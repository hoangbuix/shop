package com.hoangbui.shopping.service;

import com.hoangbui.shopping.entity.BrandEntity;
import com.hoangbui.shopping.model.req.create.CreateBrandReq;
import com.hoangbui.shopping.model.req.update.UpdateBrandReq;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface BrandService {
    BrandEntity save(CreateBrandReq req);
    BrandEntity update(UpdateBrandReq req);
    void delete(int id);
    BrandEntity findById(int id);
    BrandEntity findByBrandName(String brandName);
    List<BrandEntity> findAll();
}
