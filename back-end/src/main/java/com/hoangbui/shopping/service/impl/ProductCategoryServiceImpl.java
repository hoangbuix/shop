package com.hoangbui.shopping.service.impl;

import com.hoangbui.shopping.dao.ProductCategoryDAO;
import com.hoangbui.shopping.entity.ProductCategoryEntity;
import com.hoangbui.shopping.exception.DuplicateRecordException;
import com.hoangbui.shopping.model.req.create.CreateProductCategoryReq;
import com.hoangbui.shopping.model.req.update.UpdateProductCategoryReq;
import com.hoangbui.shopping.service.ProductCategoryService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ProductCategoryServiceImpl implements ProductCategoryService {
    final Logger log = Logger.getLogger(ProductCategoryServiceImpl.class);

    @Autowired
    private ProductCategoryDAO<ProductCategoryEntity> productCategoryDAO;

    @Override
    public ProductCategoryEntity save(CreateProductCategoryReq req) {
        int id = 0;
        try {
            ProductCategoryEntity productCategory = new ProductCategoryEntity();
            ProductCategoryEntity check = productCategoryDAO.findByProductIdAndCategoryId(req.getProductId(), req.getCategoryId());
            if (check != null) {
                throw new DuplicateRecordException("Exist");
            } else {
                productCategory.setCategoryId(req.getCategoryId());
                productCategory.setProductId(req.getProductId());
                id = productCategoryDAO.save(productCategory);
            }
        } catch (Exception e) {
            e.printStackTrace();
            log.error(e.getMessage());
        }
        return productCategoryDAO.findById(id);
    }

    @Override
    public ProductCategoryEntity update(UpdateProductCategoryReq req) {
        try {
            ProductCategoryEntity productCategory = new ProductCategoryEntity();
            productCategory.setProductId(req.getProductId());
            productCategory.setCategoryId(req.getCategoryId());
            productCategory.setActiveFlag(req.getActiveFlag());
            productCategoryDAO.update(productCategory);
        } catch (Exception e) {
            e.printStackTrace();
            log.error(e.getMessage());
        }
        return productCategoryDAO.findByProductIdAndCategoryId(req.getProductId(), req.getCategoryId());
    }

    @Override
    public void delete(int id) {
        productCategoryDAO.delete(id);
    }

    @Override
    public ProductCategoryEntity findById(int id) {
        return productCategoryDAO.findById(id);
    }

    @Override
    public ProductCategoryEntity findByProductIdAndCategoryId(int productId, int categoryId) {
        return productCategoryDAO.findByProductIdAndCategoryId(productId, categoryId);
    }

    @Override
    public List<ProductCategoryEntity> findAll() {
        return productCategoryDAO.findAll();
    }
}
