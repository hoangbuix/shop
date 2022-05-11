package com.hoangbui.shopping.dao.impl;

import com.hoangbui.shopping.dao.CategoryDAO;
import com.hoangbui.shopping.entity.CategoryEntity;
import com.hoangbui.shopping.model.mapper.CategoryMapper;
import com.hoangbui.shopping.util.QueryConstant;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import static com.hoangbui.shopping.util.SqlConstant.*;

@Component
@Transactional(rollbackFor = Exception.class)
public class CategoryDAOImpl extends BaseDAOImpl<CategoryEntity> implements CategoryDAO<CategoryEntity> {
    final String CATEGORY = "category";

    @Override
    public int save(CategoryEntity cate) {
        return insert(QueryConstant.callQueryUpdate(CATEGORY, CREATE, 3),cate.getCategoryCode(), cate.getCategoryName(),
                cate.getDescription());
    }

    @Override
    public void update(CategoryEntity cate) {
        update(QueryConstant.callQueryUpdate(CATEGORY, UPDATE, 5), cate.getId(), cate.getCategoryName(), cate.getCategoryCode(),
                cate.getDescription(), cate.getActiveFlag());
    }

    @Override
    public void delete(int id) {
        delete(QueryConstant.callQueryUpdate(CATEGORY, DELETE, 1), id);
    }

    @Override
    public List<CategoryEntity> findAll() {
        return query(QueryConstant.callQueryUpdate(CATEGORY, FIND_ALL, 0), new CategoryMapper());
    }

    @Override
    public CategoryEntity findById(int id) {
        List<CategoryEntity> cate = query(QueryConstant.callQueryUpdate(CATEGORY, FIND_BY_ID, 1), new CategoryMapper(), id);
        return cate.isEmpty() ? null : cate.get(0);
    }

    @Override
    public CategoryEntity findByCode(String code) {
        List<CategoryEntity> cate = query(QueryConstant.callQueryUpdate(CATEGORY, "_findCategoryByCode", 1), new CategoryMapper(), code);
        return cate.isEmpty() ? null : cate.get(0);
    }
}
