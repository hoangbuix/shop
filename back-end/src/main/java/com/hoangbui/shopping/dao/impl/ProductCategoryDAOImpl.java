package com.hoangbui.shopping.dao.impl;

import com.hoangbui.shopping.dao.ProductCategoryDAO;
import com.hoangbui.shopping.entity.ProductCategoryEntity;
import com.hoangbui.shopping.model.mapper.ProductCategoryMapper;
import com.hoangbui.shopping.util.QueryConstant;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import static com.hoangbui.shopping.util.SqlConstant.*;

@Component
@Transactional(rollbackFor = Exception.class)
public class ProductCategoryDAOImpl extends BaseDAOImpl<ProductCategoryEntity>
        implements ProductCategoryDAO<ProductCategoryEntity> {
    final String PRODUCT_CATE = "productCategory";

    @Override
    public int save(ProductCategoryEntity productCategory) {
        return insert(QueryConstant.callQueryUpdate(PRODUCT_CATE, CREATE, 2), productCategory.getProductId(),
                productCategory.getCategoryId());
    }

    @Override
    public void update(ProductCategoryEntity productCategory) {
        update(QueryConstant.callQueryUpdate(PRODUCT_CATE, UPDATE, 3), productCategory.getProductId(),
                productCategory.getCategoryId(),
                productCategory.getActiveFlag());
    }

    @Override
    public void delete(int id) {
        delete(QueryConstant.callQueryUpdate(PRODUCT_CATE, DELETE, 1), id);
    }

    @Override
    public List<ProductCategoryEntity> findAll() {
        return query(QueryConstant.callQueryUpdate(PRODUCT_CATE, FIND_ALL, 0), new ProductCategoryMapper());
    }

    @Override
    public ProductCategoryEntity findById(int id) {
        List<ProductCategoryEntity> productCategory = query(QueryConstant.callQueryUpdate(PRODUCT_CATE, FIND_BY_ID, 1),
                new ProductCategoryMapper(), id);
        return productCategory.isEmpty() ? null : productCategory.get(0);
    }

    @Override
    public ProductCategoryEntity findByProductIdAndCategoryId(int productId, int categoryId) {
        List<ProductCategoryEntity> productCategory = query(
                QueryConstant.callQueryUpdate(PRODUCT_CATE, "_findByProductIdAndCategoryId", 2),
                new ProductCategoryMapper(), productId, categoryId);
        return productCategory.isEmpty() ? null : productCategory.get(0);
    }
}
