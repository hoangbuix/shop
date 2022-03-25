package com.hoangbui.shopping.dao.impl;

import com.hoangbui.shopping.dao.PromotionDAO;
import com.hoangbui.shopping.entity.PromotionEntity;
import com.hoangbui.shopping.model.mapper.PromotionMapper;
import com.hoangbui.shopping.util.QueryConstant;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import static com.hoangbui.shopping.util.SqlConstant.*;

@Component
@Transactional(rollbackFor = Exception.class)
public class PromotionDAOImpl extends BaseDAOImpl<PromotionEntity> implements PromotionDAO<PromotionEntity> {
    final String PROMOTION = "promotion";

    @Override
    public int save(PromotionEntity promotion) {
        return insert(QueryConstant.callQueryUpdate(PROMOTION, CREATE, 7), promotion.getName(), promotion.getCouponCode(),
                promotion.getDiscountType(), promotion.getDiscountValue(), promotion.getMaximumDiscountValue(), promotion.isActive(),
                promotion.isPublic());
    }

    @Override
    public void update(PromotionEntity promotion) {
        update(QueryConstant.callQueryUpdate(PROMOTION, UPDATE, 8), promotion.getName(), promotion.getCouponCode(),
                promotion.getDiscountType(), promotion.getDiscountValue(), promotion.getMaximumDiscountValue(), promotion.isActive(),
                promotion.isPublic(), promotion.getActiveFlag());
    }

    @Override
    public void delete(int id) {
        delete(QueryConstant.callQueryUpdate(PROMOTION, DELETE, 1), id);
    }

    @Override
    public List<PromotionEntity> findAll() {
        return query(QueryConstant.callQueryUpdate(PROMOTION, FIND_ALL, 0), new PromotionMapper());
    }

    @Override
    public PromotionEntity findById(int id) {
        List<PromotionEntity> promotion = query(QueryConstant.callQueryUpdate(PROMOTION, FIND_BY_ID, 1), new PromotionMapper(), id);
        return promotion.isEmpty() ? null : promotion.get(0);
    }
}
