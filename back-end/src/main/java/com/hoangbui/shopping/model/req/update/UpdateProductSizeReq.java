package com.hoangbui.shopping.model.req.update;

import lombok.Data;

@Data
public class UpdateProductSizeReq {
    private int size;
    private int quantity;
    private int activeFLag;
}
