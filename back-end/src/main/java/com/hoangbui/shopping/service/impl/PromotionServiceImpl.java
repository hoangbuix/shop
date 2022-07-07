package com.hoangbui.shopping.service.impl;

import com.hoangbui.shopping.dao.PromotionDAO;
import com.hoangbui.shopping.entity.PromotionEntity;
import com.hoangbui.shopping.model.req.create.CreatePromotionReq;
import com.hoangbui.shopping.model.req.update.UpdatePromotionReq;
import com.hoangbui.shopping.service.PromotionService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PromotionServiceImpl implements PromotionService {
    final Logger log = Logger.getLogger(PromotionServiceImpl.class);

    @Autowired
    private PromotionDAO<PromotionEntity> promotionDAO;

    @Override
    public PromotionEntity save(CreatePromotionReq req) {
        int id = 0;
        try {
            PromotionEntity promotion = new PromotionEntity();
            promotion.setCouponCode(req.getCouponCode());
            promotion.setName(req.getName());
            promotion.setDiscountType(req.getDiscountType());
            promotion.setCouponCode(req.getCouponCode());
            promotion.setMaximumDiscountValue(req.getMaximumDiscountValue());
            promotion.setActive(req.isActive());
            promotion.setPublic(req.isPublic());
            id = promotionDAO.save(promotion);
        } catch (Exception e) {
            e.printStackTrace();
            log.error(e.getMessage());
            return null;
        }
        return promotionDAO.findById(id);
    }

    @Override
    public PromotionEntity update(UpdatePromotionReq req) {
        PromotionEntity promotion = new PromotionEntity();
        try {
            promotion.setCouponCode(req.getCouponCode());
            promotion.setName(req.getName());
            promotion.setDiscountType(req.getDiscountType());
            promotion.setCouponCode(req.getCouponCode());
            promotion.setMaximumDiscountValue(req.getMaximumDiscountValue());
            promotion.setActive(req.isActive());
            promotion.setPublic(req.isPublic());
            promotion.setActiveFlag(req.getActiveFlag());
            promotionDAO.update(promotion);
        } catch (Exception e) {
            e.printStackTrace();
            log.error(e.getMessage());
            return null;
        }
        return promotion;
    }

    @Override
    public void delete(int id) {
        try {
            promotionDAO.delete(id);
        } catch (Exception e) {
            e.printStackTrace();
            log.error(e.getMessage());
        }
    }

    @Override
    public List<PromotionEntity> findAll() {
        return promotionDAO.findAll();
    }

    @Override
    public PromotionEntity findById(int id) {
        return promotionDAO.findById(id);
    }
}
