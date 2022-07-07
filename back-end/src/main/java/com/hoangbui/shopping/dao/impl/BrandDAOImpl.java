package com.hoangbui.shopping.dao.impl;

import com.hoangbui.shopping.dao.BrandDAO;
import com.hoangbui.shopping.entity.BrandEntity;
import com.hoangbui.shopping.model.mapper.BrandMapper;
import com.hoangbui.shopping.util.QueryConstant;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static com.hoangbui.shopping.util.SqlConstant.*;

@Component
@Transactional(rollbackFor = Exception.class)
public class BrandDAOImpl extends BaseDAOImpl<BrandEntity> implements BrandDAO<BrandEntity> {
    final String BRAND = "brand";

    @Override
    public int save(BrandEntity brand) {
        return insert(QueryConstant.callQueryUpdate(BRAND, CREATE, 2), brand.getBrandName(), brand.getThumbnail());
    }

    @Override
    public void update(BrandEntity brand) {
        update(QueryConstant.callQueryUpdate(BRAND, UPDATE, 3), brand.getBrandName(), brand.getThumbnail(), brand.getActiveFlag());
    }

    @Override
    public void delete(int id) {
        delete(QueryConstant.callQueryUpdate(BRAND, DELETE, 1), id);
    }

    @Override
    public List<BrandEntity> findAll() {
        return query(QueryConstant.callQueryUpdate(BRAND, FIND_ALL, 0), new BrandMapper());
    }

    @Override
    public BrandEntity findById(int id) {
        List<BrandEntity> brand = query(QueryConstant.callQueryUpdate(BRAND, FIND_BY_ID, 1), new BrandMapper(), id);
        return brand.isEmpty() ? null : brand.get(0);
    }

    @Override
    public BrandEntity findByBrandName(String brandName) {
        List<BrandEntity> brand = query(QueryConstant.callQueryUpdate(BRAND, "_findByBrandName", 1), new BrandMapper(), brandName);
        return brand.isEmpty() ? null : brand.get(0);
    }
}
