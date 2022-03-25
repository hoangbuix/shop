package com.hoangbui.shopping.model.req.create;

import lombok.Data;

@Data
public class CreatePromotionReq {
    private String name;

    private String couponCode;

    private String discountType;

    private int discountValue;

    private int maximumDiscountValue;

    private boolean isActive;

    private boolean isPublic;
}
