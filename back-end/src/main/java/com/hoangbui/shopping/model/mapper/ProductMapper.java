package com.hoangbui.shopping.model.mapper;

import com.hoangbui.shopping.entity.BrandEntity;
import com.hoangbui.shopping.entity.CategoryEntity;
import com.hoangbui.shopping.entity.ProductEntity;
import com.hoangbui.shopping.entity.ProductSizeEntity;

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
            product.setActiveFlag(resultSet.getInt("active_flag"));
            product.setCreatedDate(resultSet.getDate("created_date"));
            product.setUpdatedDate(resultSet.getDate("updated_date"));
            try {
                BrandEntity brand = new BrandEntity();
                brand.setId(resultSet.getInt("id"));
                brand.setBrandName(resultSet.getString("brand_name"));
                brand.setThumbnail(resultSet.getString("thumbnail"));
                brand.setActiveFlag(resultSet.getInt("active_flag"));
//                brand.setCreatedDate(resultSet.getDate("created_date"));
//                brand.setUpdatedDate(resultSet.getDate("updated_date"));
                product.setBrand(brand);
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                CategoryEntity cate = new CategoryEntity();
                cate.setId(resultSet.getInt("id"));
                cate.setCategoryName(resultSet.getString("category_name"));
                cate.setCategoryCode(resultSet.getString("category_code"));
                cate.setDescription(resultSet.getString("description"));
                cate.setActiveFlag(resultSet.getInt("active_flag"));
//                cate.setCreatedDate(resultSet.getDate("created_date"));
//                cate.setUpdatedDate(resultSet.getDate("updated_date"));
                product.setCategory(cate);
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                ProductSizeEntity productSize = new ProductSizeEntity();
                productSize.setId(resultSet.getInt("id"));
                productSize.setSize(resultSet.getString("size"));
                productSize.setSizeCode(resultSet.getString("size_code"));
                productSize.setQuantity(resultSet.getString("quantity"));
                productSize.setGender(resultSet.getString("gender"));
                productSize.setActiveFlag(resultSet.getInt("active_flag"));
//                productSize.setCreatedDate(resultSet.getDate("created_date"));
//                productSize.setUpdatedDate(resultSet.getDate("updated_date"));
                product.setProductSize(productSize);
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return product;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}
