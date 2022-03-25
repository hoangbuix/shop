package com.hoangbui.shopping.model.req.create;

import lombok.Data;

@Data
public class CreateCategoryReq {
    private String categoryName;
    private String categoryCode;
    private String description;
}
