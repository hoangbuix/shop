package com.hoangbui.shopping.model.req.create;

import lombok.Data;

@Data
public class CreateProductSizeReq {
    private String size;
    private String sizeCode;
    private String quantity;
    private String gender;
    private int activeFlag;
}
