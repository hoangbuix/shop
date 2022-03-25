package com.hoangbui.shopping.dao.impl;

import com.hoangbui.shopping.dao.OrderDAO;
import com.hoangbui.shopping.entity.OrderEntity;
import com.hoangbui.shopping.model.mapper.OrderMapper;
import com.hoangbui.shopping.util.QueryConstant;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import static  com.hoangbui.shopping.util.SqlConstant.*;

@Component
@Transactional(rollbackFor = Exception.class)
public class OrderDAOImpl extends BaseDAOImpl<OrderEntity> implements OrderDAO<OrderEntity> {

    final Logger log = Logger.getLogger(OrderDAOImpl.class);
    private final String ORDER = "orders";

    @Override
    public int save(OrderEntity order) {
        return insert(QueryConstant.callQueryUpdate(ORDER, CREATE, 13), order.getNote(), order.getProductPrice(),
                order.getPromotionId(), order.getProductId(), order.getProductSize(), order.getReceiverAddress(),
                order.getReceiverName(), order.getReceiverPhone(), order.getStatus(), order.getTotalPrice(), order.getBuyer(),
                order.getCreatedBy(), order.getModifiedBy());
    }

    @Override
    public void update(OrderEntity order) {
        update(QueryConstant.callQueryUpdate(ORDER, UPDATE, 14), order.getNote(), order.getProductPrice(),
                order.getPromotionId(), order.getProductId(), order.getProductSize(), order.getReceiverAddress(),
                order.getReceiverName(), order.getReceiverPhone(), order.getStatus(), order.getTotalPrice(), order.getBuyer(),
                order.getCreatedBy(), order.getModifiedBy(), order.getActiveFlag());
    }

    @Override
    public void delete(int id) {
        delete(QueryConstant.callQueryUpdate(ORDER, DELETE, 1), id);
    }

    @Override
    public List<OrderEntity> findAll() {
        return query(QueryConstant.callQueryUpdate(ORDER, FIND_ALL, 0), new OrderMapper());
    }

    @Override
    public OrderEntity findById(int id) {
        List<OrderEntity>orders = query(QueryConstant.callQueryUpdate(ORDER, FIND_BY_ID, 1), new OrderMapper(), id);
        return orders.isEmpty() ? null : orders.get(0);
    }
}
