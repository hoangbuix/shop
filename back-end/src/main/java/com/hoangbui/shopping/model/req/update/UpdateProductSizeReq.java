package com.hoangbui.shopping.model.req.update;

import lombok.Data;

@Data
public class UpdateProductSizeReq {
    private String size;
    private String quantity;
    private String gender;
    private int activeFLag;
}
