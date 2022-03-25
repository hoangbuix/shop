package com.hoangbui.shopping.model.mapper;

import com.hoangbui.shopping.entity.ProductCategoryEntity;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ProductCategoryMapper implements RowMapper<ProductCategoryEntity> {
    @Override
    public ProductCategoryEntity mapRow(ResultSet resultSet) {
        try {
            ProductCategoryEntity productCategory = new ProductCategoryEntity();
            productCategory.setId(resultSet.getInt("id"));
            productCategory.setProductId(resultSet.getInt("product_id"));
            productCategory.setCategoryId(resultSet.getInt("category_id"));
            productCategory.setActiveFlag(resultSet.getInt("active_flag"));
            productCategory.setCreatedDate(resultSet.getDate("created_date"));
            productCategory.setUpdatedDate(resultSet.getDate("updated_date"));
            return productCategory;
        }catch (SQLException e) {
            return null;
        }
    }
}
