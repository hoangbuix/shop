package com.hoangbui.shopping.model.req.update;

import lombok.Data;

@Data
public class UpdateProductCategoryReq {
    private int productId;
    private int categoryId;
    private int activeFlag;
}
