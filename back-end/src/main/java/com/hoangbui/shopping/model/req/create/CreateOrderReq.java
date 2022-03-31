package com.hoangbui.shopping.model.req.create;

import lombok.Data;

@Data
public class CreateOrderReq {
    private String note;
    private float productPrice;
    private int promotionId;
    private int productId;
    private int productSize;
    private String receiverAddress;
    private String receiverName;
    private String receiverPhone;
    private String status;
    private int totalPrice;
    private int buyer;
    private int createdBy;
    private int modifiedBy;
    private int activeFlag;
}
