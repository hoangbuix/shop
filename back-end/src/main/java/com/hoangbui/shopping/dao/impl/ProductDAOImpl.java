package com.hoangbui.shopping.dao.impl;

import com.hoangbui.shopping.dao.ProductDAO;
import com.hoangbui.shopping.entity.ProductEntity;
import com.hoangbui.shopping.model.mapper.ProductMapper;
import com.hoangbui.shopping.util.QueryConstant;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static com.hoangbui.shopping.util.SqlConstant.*;

@Component
@Transactional(rollbackFor = Exception.class)
public class ProductDAOImpl extends BaseDAOImpl<ProductEntity> implements ProductDAO<ProductEntity> {
    final String PRODUCT = "product";

    @Override
    public int save(ProductEntity product) {
        return insert(QueryConstant.callQueryUpdate(PRODUCT, CREATE, 12), product.getProductCode(),
                product.getProductName(),
                product.getDescription(), product.getSlug(), product.getBrand().getId(), product.getPrice(),
                product.getProductImage(), product.getTotalProduct(),
                product.getTotalSold(), product.getQuantityProduct(), product.getCategory().getId(),
                product.getProductSize().getId());
    }

    @Override
    public void update(ProductEntity product) {
        update(QueryConstant.callQueryUpdate(PRODUCT, CREATE, 12), product.getProductCode(),
                product.getProductName(),
                product.getDescription(), product.getSlug(), product.getBrand().getId(), product.getPrice(),
                product.getProductImage(), product.getTotalProduct(),
                product.getTotalSold(), product.getQuantityProduct(), product.getCategory().getId(),
                product.getProductSize().getId(), product.getActiveFlag());
    }

    @Override
    public void delete(int id) {
        delete(QueryConstant.callQueryUpdate(PRODUCT, DELETE, 1), id);
    }

    @Override
    public List<ProductEntity> findAll() {
        return query(QueryConstant.callQueryUpdate(PRODUCT, FIND_ALL, 0), new ProductMapper());
    }

    @Override
    public ProductEntity findById(int id) {
        List<ProductEntity> product = query(QueryConstant.callQueryUpdate(PRODUCT, FIND_BY_ID, 1), new ProductMapper(),
                id);
        return product.isEmpty() ? null : product.get(0);
    }

    @Override
    public int checkTotalProduct() {
        int count = queryId(QueryConstant.callQueryUpdate(PRODUCT, "_checkTotalProduct", 0), new ProductMapper());
        return count;
    }
}
