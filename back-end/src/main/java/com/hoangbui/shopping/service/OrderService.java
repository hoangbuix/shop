package com.hoangbui.shopping.service;

import com.hoangbui.shopping.entity.OrderEntity;
import com.hoangbui.shopping.model.req.create.CreateOrderReq;
import com.hoangbui.shopping.model.req.update.UpdateOrderReq;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface OrderService  {
    OrderEntity save(CreateOrderReq req, int userId);
    OrderEntity update(UpdateOrderReq req);
    void delete(int id);
    OrderEntity findById(int id);
    List<OrderEntity> findAll();
}
