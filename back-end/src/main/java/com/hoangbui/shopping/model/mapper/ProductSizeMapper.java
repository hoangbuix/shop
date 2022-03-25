package com.hoangbui.shopping.model.mapper;

import com.hoangbui.shopping.entity.ProductSizeEntity;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ProductSizeMapper implements RowMapper<ProductSizeEntity> {
    @Override
    public ProductSizeEntity mapRow(ResultSet resultSet) {
        try {
            ProductSizeEntity productSize = new ProductSizeEntity();
            productSize.setId(resultSet.getInt("id"));
            productSize.setSize(resultSet.getInt("size"));
            productSize.setQuantity(resultSet.getInt("quantity"));
            productSize.setActiveFlag(resultSet.getInt("active_flag"));
            productSize.setCreatedDate(resultSet.getDate("created_date"));
            productSize.setUpdatedDate(resultSet.getDate("updated_date"));
            return productSize;
        }catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}
