package com.hoangbui.shopping.model.req.update;

import lombok.Data;

@Data
public class UpdatePostReq extends UpdateCommonReq {
    private String content;
    private String slug;
    private String title;
    private String thumbnail;
    private String description;
}
