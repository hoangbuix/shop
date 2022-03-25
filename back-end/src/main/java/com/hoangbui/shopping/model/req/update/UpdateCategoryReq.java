package com.hoangbui.shopping.model.req.update;

import lombok.Data;

@Data
public class UpdateCategoryReq {
    private String categoryName;
    private String categoryCode;
    private String description;
    private int activeFlag;
}
