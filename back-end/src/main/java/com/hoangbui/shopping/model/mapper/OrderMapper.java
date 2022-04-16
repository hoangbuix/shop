package com.hoangbui.shopping.model.mapper;

import com.hoangbui.shopping.entity.OrderEntity;

import java.sql.ResultSet;

public class OrderMapper implements RowMapper<OrderEntity> {
    @Override
    public OrderEntity mapRow(ResultSet resultSet) {
        OrderEntity order = new OrderEntity();

        return order;
    }
}
