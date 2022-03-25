package com.hoangbui.shopping.model.mapper;

import com.hoangbui.shopping.entity.BrandEntity;

import java.sql.ResultSet;
import java.sql.SQLException;

public class BrandMapper implements RowMapper<BrandEntity> {
    @Override
    public BrandEntity mapRow(ResultSet resultSet) {
        try {
            BrandEntity brand = new BrandEntity();
            brand.setId(resultSet.getInt("id"));
            brand.setBrandName(resultSet.getString("brand_name"));
            brand.setThumbnail(resultSet.getString("thumbnail"));
            brand.setActiveFlag(resultSet.getInt("active_flag"));
            brand.setCreatedDate(resultSet.getDate("created_date"));
            brand.setUpdatedDate(resultSet.getDate("updated_date"));
            return brand;
        }catch (SQLException e){
            e.printStackTrace();
            return null;
        }
    }
}
