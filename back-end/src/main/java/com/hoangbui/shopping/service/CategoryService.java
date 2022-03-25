package com.hoangbui.shopping.service;

import com.hoangbui.shopping.entity.CategoryEntity;
import com.hoangbui.shopping.model.req.create.CreateCategoryReq;
import com.hoangbui.shopping.model.req.update.UpdateCategoryReq;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CategoryService {
    CategoryEntity findById(int id);
    CategoryEntity findByCode(String code);
    List<CategoryEntity> findAll();
    CategoryEntity save(CreateCategoryReq req);
    CategoryEntity update(UpdateCategoryReq req);
    void delete(int id);
}
