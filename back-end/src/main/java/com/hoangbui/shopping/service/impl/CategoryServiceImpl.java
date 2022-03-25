package com.hoangbui.shopping.service.impl;

import com.hoangbui.shopping.dao.CategoryDAO;
import com.hoangbui.shopping.entity.CategoryEntity;
import com.hoangbui.shopping.exception.DuplicateRecordException;
import com.hoangbui.shopping.model.req.create.CreateCategoryReq;
import com.hoangbui.shopping.model.req.update.UpdateCategoryReq;
import com.hoangbui.shopping.service.CategoryService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CategoryServiceImpl implements CategoryService {
    final Logger log = Logger.getLogger(CategoryService.class);

    @Autowired
    private CategoryDAO<CategoryEntity> categoryDAO;

    @Override
    public CategoryEntity findById(int id) {
        CategoryEntity cate = categoryDAO.findById(id);
        return cate;
    }

    @Override
    public CategoryEntity findByCode(String code) {
        return categoryDAO.findByCode(code);
    }

    @Override
    public List<CategoryEntity> findAll() {
        return categoryDAO.findAll();
    }

    @Override
    public CategoryEntity save(CreateCategoryReq req) {
        int id = 0;
        try {
            CategoryEntity cate = new CategoryEntity();
            cate.setCategoryCode(req.getCategoryCode());
            cate.setCategoryName(req.getCategoryName());
            cate.setDescription(req.getDescription());
            id = categoryDAO.save(cate);
        }catch (Exception e) {
            e.printStackTrace();
            log.error(e.getMessage());
        }
        return categoryDAO.findById(id);
    }

    @Override
    public CategoryEntity update(UpdateCategoryReq req) {
        try {
            CategoryEntity cate = new CategoryEntity();
            cate.setCategoryCode(req.getCategoryCode());
            cate.setCategoryName(req.getCategoryName());
            cate.setDescription(req.getDescription());
            cate.setActiveFlag(req.getActiveFlag());
            categoryDAO.update(cate);

        }catch (Exception e) {
            e.printStackTrace();
            log.error(e.getMessage());
        }
        return categoryDAO.findByCode(req.getCategoryCode());
    }

    @Override
    public void delete(int id) {
        try {
            categoryDAO.delete(id);
        }catch (Exception e) {
            e.printStackTrace();
            log.error(e.getMessage());
        }
    }
}
