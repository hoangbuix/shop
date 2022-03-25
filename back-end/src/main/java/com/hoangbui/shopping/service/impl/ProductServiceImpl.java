package com.hoangbui.shopping.service.impl;

import com.hoangbui.shopping.dao.ProductCategoryDAO;
import com.hoangbui.shopping.dao.ProductDAO;
import com.hoangbui.shopping.entity.ProductCategoryEntity;
import com.hoangbui.shopping.entity.ProductEntity;
import com.hoangbui.shopping.model.req.create.CreateProductReq;
import com.hoangbui.shopping.model.req.update.UpdateProductReq;
import com.hoangbui.shopping.service.ProductService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ProductServiceImpl implements ProductService {
    final Logger log = Logger.getLogger(ProductServiceImpl.class);

    @Autowired
    private ProductDAO<ProductEntity> productDAO;

    @Autowired
    private ProductCategoryDAO<ProductCategoryEntity> productCategoryDAO;

    @Override
    public int checkTotalProduct() {
        return productDAO.checkTotalProduct();
    }

    @Override
    public List<ProductEntity> findAll() {
        return productDAO.findAll();
    }

    @Override
    public ProductEntity findById(int id) {
        return productDAO.findById(id);
    }

    @Override
    public ProductEntity save(CreateProductReq req) {
        int id = 0;
        try {
            ProductEntity product = new ProductEntity();
            product.setProductName(req.getProductName());
            product.setProductCode(req.getProductCode());
            product.setDescription(req.getDescription());
            product.setSlug(req.getSlug());
            product.setPrice(req.getPrice());
            product.setProductImage(req.getProductImage());
            product.setTotalProduct(req.getTotalProduct());
            product.setTotalSold(req.getTotalSold());
            product.setQuantityProduct(req.getQuantityProduct());
            product.setBrandId(req.getBrandId());
            product.setCategoryId(req.getCategoryId());
            product.setProductSize(req.getProductSize());
            id = productDAO.save(product);
            ProductCategoryEntity productCategory = new ProductCategoryEntity();
            productCategory.setProductId(id);
            productCategory.setCategoryId(req.getCategoryId());
            productCategoryDAO.save(productCategory);
        }catch (Exception e){
            e.printStackTrace();
            log.error(e.getMessage());
        }
        return productDAO.findById(id);
    }

    @Override
    public ProductEntity update(UpdateProductReq req) {
        try {
            ProductEntity product = new ProductEntity();
            productDAO.save(product);
        } catch (Exception e){
            e.printStackTrace();
            log.error(e.getMessage());
        }

        return null;
    }

    @Override
    public void delete(int id) {
        try {
            productDAO.delete(id);
        }catch (Exception e){
            e.printStackTrace();
            log.error(e.getMessage());
        }
    }
}
