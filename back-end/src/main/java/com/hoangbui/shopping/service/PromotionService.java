package com.hoangbui.shopping.service;

import com.hoangbui.shopping.entity.PromotionEntity;
import com.hoangbui.shopping.model.req.create.CreatePromotionReq;
import com.hoangbui.shopping.model.req.update.UpdatePromotionReq;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PromotionService {
    PromotionEntity save(CreatePromotionReq req);

    PromotionEntity update(UpdatePromotionReq req);

    void delete(int id);

    List<PromotionEntity> findAll();

    PromotionEntity findById(int id);
}
