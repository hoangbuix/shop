package com.hoangbui.shopping.model.req.update;

import lombok.Data;

@Data
public class UpdatePromotionReq {
    private String name;

    private String couponCode;

    private String discountType;

    private int discountValue;

    private int maximumDiscountValue;

    private boolean isActive;

    private boolean isPublic;

    private int activeFlag;
}
