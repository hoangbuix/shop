package com.hoangbui.shopping.model.conveter;

import com.hoangbui.shopping.entity.PostEntity;
import com.hoangbui.shopping.model.req.create.CreatePostReq;

public class PostConverter {
    public static PostEntity toEntity(CreatePostReq req){
        PostEntity post = new PostEntity();
        post.setContent(req.getContent());
        post.setSlug(req.getSlug());
        post.setThumbnail(req.getThumbnail());
        post.setTitle(req.getTitle());
        post.setDescription(req.getDescription());
        return post;
    }

}
