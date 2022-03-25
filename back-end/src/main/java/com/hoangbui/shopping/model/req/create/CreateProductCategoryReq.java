package com.hoangbui.shopping.model.req.create;

import lombok.Data;

@Data
public class CreateProductCategoryReq {
    private int productId;
    private int categoryId;
    private int activeFlag;
}
