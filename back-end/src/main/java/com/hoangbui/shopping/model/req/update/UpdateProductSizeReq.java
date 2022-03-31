package com.hoangbui.shopping.model.req.update;

import lombok.Data;

@Data
public class UpdateProductSizeReq {
    private int id;
    private String sizeCode;
    private String gender;
    private int activeFlag;
}

