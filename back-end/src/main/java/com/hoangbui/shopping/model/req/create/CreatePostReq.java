package com.hoangbui.shopping.model.req.create;

import lombok.Data;

@Data
public class CreatePostReq {
    private String content;
    private String slug;
    private String title;
    private String thumbnail;
    private String description;
}
