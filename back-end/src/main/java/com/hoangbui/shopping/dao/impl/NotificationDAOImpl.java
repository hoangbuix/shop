package com.hoangbui.shopping.dao.impl;

import com.hoangbui.shopping.dao.NotificationDAO;
import com.hoangbui.shopping.entity.NotificationEntity;
import com.hoangbui.shopping.model.mapper.NotificationMapper;
import com.hoangbui.shopping.util.QueryConstant;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static com.hoangbui.shopping.util.SqlConstant.*;

@Component
@Transactional(rollbackFor = Exception.class)
public class NotificationDAOImpl extends BaseDAOImpl<NotificationEntity> implements NotificationDAO<NotificationEntity> {
    final String NOTIFICATION = "notification";


    @Override
    public int save(NotificationEntity notification) {
        return insert(QueryConstant.callQueryUpdate(NOTIFICATION, CREATE, 4), notification.getNotificationName().toString(),
                notification.getSeen(), notification.getUser().getId(), notification.getPost().getId());
    }

    @Override
    public void update(NotificationEntity notification) {
        update(QueryConstant.callQueryUpdate(NOTIFICATION, UPDATE, 6),
                notification.getId(),
                notification.getNotificationName().toString(), notification.getSeen(),
                notification.getUser().getId(), notification.getPost().getId(),
                notification.getActiveFlag());
    }

    @Override
    public void delete(int id) {
        try {
            delete(QueryConstant.callQueryUpdate(NOTIFICATION, DELETE, 1), id);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<NotificationEntity> findAll() {
        return query(QueryConstant.callQueryUpdate(NOTIFICATION, FIND_ALL, 0), new NotificationMapper());
    }

    @Override
    public NotificationEntity findById(int id) {
        List<NotificationEntity> notification = query(QueryConstant.callQueryUpdate(NOTIFICATION, FIND_BY_ID, 1), new NotificationMapper(), id);
        return notification.isEmpty() ? null : notification.get(0);
    }

    @Override
    public List<NotificationEntity> findAllByUserId(int id) {
        return query(QueryConstant.callQueryUpdate(NOTIFICATION, "_findAllByUserId", 1), new NotificationMapper(), id);
    }
}
