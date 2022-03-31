package com.hoangbui.shopping.service.impl;

import com.hoangbui.shopping.dao.OrderDAO;
import com.hoangbui.shopping.dao.UserDAO;
import com.hoangbui.shopping.entity.OrderEntity;
import com.hoangbui.shopping.entity.UserEntity;
import com.hoangbui.shopping.exception.NotFoundException;
import com.hoangbui.shopping.model.req.create.CreateOrderReq;
import com.hoangbui.shopping.model.req.update.UpdateOrderReq;
import com.hoangbui.shopping.service.OrderService;
import com.hoangbui.shopping.util.Status;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class OrderServiceImpl implements OrderService {
    final Logger log = Logger.getLogger(OrderServiceImpl.class);

    @Autowired
    private OrderDAO<OrderEntity> orderDAO;

    @Autowired
    private UserDAO<UserEntity> userDAO;

    @Override
    public OrderEntity save(CreateOrderReq req,int userId) {
        int id = 0;
        try {
            UserEntity checkUser = userDAO.findById(userId);
            if(checkUser == null) {
                throw new NotFoundException("User Not Found");
            } else {
                OrderEntity order = new OrderEntity();
                order.setNote(req.getNote());
                order.setProductPrice(req.getProductPrice());
                order.setPromotionId(req.getPromotionId());
                order.setProductId(req.getProductId());
                order.setProductSize(req.getProductSize());
                order.setReceiverName(req.getReceiverName());
                order.setReceiverAddress(req.getReceiverAddress());
                order.setReceiverPhone(req.getReceiverPhone());
                order.setStatus(Status.ORDERING.toString());
                order.setTotalPrice(req.getTotalPrice());
                order.setBuyer(userId);
                order.setCreatedBy(req.getCreatedBy());
                order.setModifiedBy(req.getModifiedBy());
                id = orderDAO.save(order);
            }
        }catch (Exception e) {
            e.printStackTrace();
            log.error(e.getMessage());
            return null;
        }
        return orderDAO.findById(id);
    }

    @Override
    public OrderEntity update(UpdateOrderReq req) {
        OrderEntity order = new OrderEntity();
        try {
            order.setNote(req.getNote());
            order.setProductPrice(req.getProductPrice());
            order.setPromotionId(req.getPromotionId());
            order.setProductId(req.getProductId());
            order.setProductSize(req.getProductSize());
            order.setReceiverName(req.getReceiverName());
            order.setReceiverAddress(req.getReceiverAddress());
            order.setReceiverPhone(req.getReceiverPhone());
            order.setStatus(req.getStatus());
            order.setTotalPrice(req.getTotalPrice());
            order.setBuyer(req.getBuyer());
            order.setCreatedBy(req.getCreatedBy());
            order.setModifiedBy(req.getModifiedBy());
            order.setActiveFlag(req.getActiveFlag());
            orderDAO.update(order);
        }catch (Exception e) {
            e.printStackTrace();
            log.error(e.getMessage());
            return null;
        }
        return order;
    }

    @Override
    public void delete(int id) {
        try {
            orderDAO.delete(id);
        } catch (Exception e) {
            e.printStackTrace();
            log.error(e.getMessage());
        }
    }

    @Override
    public OrderEntity findById(int id) {
        return orderDAO.findById(id);
    }

    @Override
    public List<OrderEntity> findAll() {
        return orderDAO.findAll();
    }
}
