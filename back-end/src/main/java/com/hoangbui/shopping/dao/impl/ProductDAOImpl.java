package com.hoangbui.shopping.dao.impl;

import com.hoangbui.shopping.dao.ProductDAO;
import com.hoangbui.shopping.entity.ProductEntity;
import com.hoangbui.shopping.model.mapper.ProductMapper;
import com.hoangbui.shopping.util.QueryConstant;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static  com.hoangbui.shopping.util.SqlConstant.*;

@Component
@Transactional(rollbackFor = Exception.class)
public class ProductDAOImpl extends BaseDAOImpl<ProductEntity> implements ProductDAO<ProductEntity> {
    final String PRODUCT = "product";

    @Override
    public int save(ProductEntity product) {
        return insert(QueryConstant.callQueryUpdate(PRODUCT, CREATE, 12), product.getProductCode(), product.getProductName(),
                product.getDescription(), product.getSlug(), product.getBrandId(), product.getPrice(), product.getProductImage(), product.getTotalProduct(),
                product.getTotalSold(), product.getQuantityProduct(), product.getCategoryId(), product.getProductSize());
    }

    @Override
    public void update(ProductEntity product) {

    }

    @Override
    public void delete(int id) {
        delete(QueryConstant.callQuery(PRODUCT, DELETE, id), id);
    }

    @Override
    public List<ProductEntity> findAll() {
        return query(QueryConstant.callQuery(PRODUCT,  FIND_ALL, null), new ProductMapper());
    }

    @Override
    public ProductEntity findById(int id) {
        List<ProductEntity> product = query(QueryConstant.callQuery(PRODUCT, FIND_BY_ID, id), new ProductMapper(), id);
        return product.isEmpty() ? null : product.get(0);
    }

    @Override
    public int checkTotalProduct() {
        int count = queryId(QueryConstant.callQuery(PRODUCT, "_checkTotalProduct", null),new ProductMapper());
        return count;
    }
}
