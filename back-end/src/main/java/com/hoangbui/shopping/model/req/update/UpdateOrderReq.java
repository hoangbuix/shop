package com.hoangbui.shopping.model.req.update;

import lombok.Data;

@Data
public class UpdateOrderReq {
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
