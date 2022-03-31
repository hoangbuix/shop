package com.hoangbui.shopping.dao.impl;

import com.hoangbui.shopping.dao.ProductSizeDAO;
import com.hoangbui.shopping.entity.ProductSizeEntity;
import com.hoangbui.shopping.model.mapper.ProductSizeMapper;
import com.hoangbui.shopping.util.QueryConstant;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import static com.hoangbui.shopping.util.SqlConstant.*;

@Component
@Transactional(rollbackFor = Exception.class)
public class ProductSizeDAOImpl extends BaseDAOImpl<ProductSizeEntity> implements ProductSizeDAO<ProductSizeEntity> {
    final String PRODUCTSIZE = "productSize";

    @Override
    public int save(ProductSizeEntity productSize) {
        return insert(QueryConstant.callQueryUpdate(PRODUCTSIZE, CREATE, 4), productSize.getSize(), productSize.getSizeCode(), productSize.getQuantity(), productSize.getGender());
    }

    @Override
    public void update(ProductSizeEntity productSize) {
        update(QueryConstant.callQueryUpdate(PRODUCTSIZE, UPDATE, 6), productSize.getId(), productSize.getSize(), productSize.getSizeCode(), productSize.getQuantity(), productSize.getGender(),
                productSize.getActiveFlag());
    }

    @Override
    public void delete(int id) {
        delete(QueryConstant.callQueryUpdate(PRODUCTSIZE, DELETE, 1), id);
    }

    @Override
    public List<ProductSizeEntity> findAll() {
        return query(QueryConstant.callQueryUpdate(PRODUCTSIZE, FIND_ALL, 0), new ProductSizeMapper());
    }

    @Override
    public ProductSizeEntity findById(int id) {
        List<ProductSizeEntity> productSize = query(QueryConstant.callQueryUpdate(PRODUCTSIZE, FIND_BY_ID, 1), new ProductSizeMapper(), id);
        return productSize.isEmpty() ? null : productSize.get(0);
    }

    @Override
    public ProductSizeEntity findBySize(String size) {
        List<ProductSizeEntity> productSize = query(QueryConstant.callQueryUpdate(PRODUCTSIZE, "_findBySize", 1), new ProductSizeMapper(), size);
        return productSize.isEmpty() ? null : productSize.get(0);
    }

    @Override
    public ProductSizeEntity findByQuantity(String quantity) {
        List<ProductSizeEntity> productSize = query(QueryConstant.callQueryUpdate(PRODUCTSIZE, "_findByQuantity", 1), new ProductSizeMapper(), quantity);
        return productSize.isEmpty() ? null : productSize.get(0);
    }

    @Override
    public ProductSizeEntity findByGender(String gender) {
        List<ProductSizeEntity> productSize = query(QueryConstant.callQueryUpdate(PRODUCTSIZE, "_findByGender", 1), new ProductSizeMapper(), gender);
        return productSize.isEmpty() ? null : productSize.get(0);
    }

    @Override
    public ProductSizeEntity findBySizeCodeAndGender(String sizeCode, String gender) {
        List<ProductSizeEntity> productSize = query(QueryConstant.callQueryUpdate(PRODUCTSIZE, "_findBySizeCodeAndGender", 2), new ProductSizeMapper(), sizeCode, gender);
        return productSize.isEmpty() ? null : productSize.get(0);
    }
}
