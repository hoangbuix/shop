package com.hoangbui.shopping.model.req.update;


import lombok.Data;

@Data
public class UpdateBrandReq {
    private String thumbnail;
    private String brandName;
    private int activeFlag;
}
