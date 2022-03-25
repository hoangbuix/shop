package com.hoangbui.shopping.model.mapper;

import com.hoangbui.shopping.entity.ProductEntity;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ProductMapper implements RowMapper<ProductEntity> {
    @Override
    public ProductEntity mapRow(ResultSet resultSet) {
        try {
            ProductEntity product = new ProductEntity();
            product.setId(resultSet.getInt("id"));
            product.setProductName(resultSet.getString("product_name"));
            product.setProductCode(resultSet.getString("product_code"));
            product.setDescription(resultSet.getString("description"));
            product.setSlug(resultSet.getString("slug"));
            product.setPrice(resultSet.getDouble("price"));
            product.setProductImage(resultSet.getString("product_image"));
            product.setQuantityProduct(resultSet.getInt("quantity_product"));
            product.setTotalProduct(resultSet.getInt("total_product"));
            product.setTotalSold(resultSet.getInt("total_sold"));
            product.setBrandId(resultSet.getInt("brand_id"));
            product.setCategoryId(resultSet.getInt("category_id"));
            product.setProductSize(resultSet.getInt("product_size"));
            return product;
        }catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}
