package com.hoangbui.shopping.service;

import com.hoangbui.shopping.entity.OrderEntity;
import com.hoangbui.shopping.entity.PostEntity;
import com.hoangbui.shopping.model.req.create.CreateOrderReq;
import com.hoangbui.shopping.model.req.create.CreatePostReq;
import com.hoangbui.shopping.model.req.update.UpdateOrderReq;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PostService {
    PostEntity save(CreatePostReq req, int userId);

    PostEntity update(CreatePostReq req, int userId);

    void delete(int id);

    PostEntity findById(int id);

    List<PostEntity> findAll();

    List<PostEntity> getPostByUserId(int userId, Authentication auth);

    PostEntity approvePost(int idPost, String usernameApproved, boolean isApprove);

}
