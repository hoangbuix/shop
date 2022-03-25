package com.hoangbui.shopping.model.req.create;

import lombok.Data;

@Data
public class CreateProductSizeReq {
    private int size;
    private int quantity;
    private int activeFLag;
}
