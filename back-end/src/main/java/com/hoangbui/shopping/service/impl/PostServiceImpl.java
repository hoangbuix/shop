package com.hoangbui.shopping.service.impl;

import com.hoangbui.shopping.config.NotificationEvent;
import com.hoangbui.shopping.dao.PostDAO;
import com.hoangbui.shopping.dao.UserDAO;
import com.hoangbui.shopping.entity.PostEntity;
import com.hoangbui.shopping.entity.UserEntity;
import com.hoangbui.shopping.exception.NotFoundException;
import com.hoangbui.shopping.model.conveter.PostConverter;
import com.hoangbui.shopping.model.req.create.CreatePostReq;
import com.hoangbui.shopping.service.PostService;
import lombok.RequiredArgsConstructor;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class PostServiceImpl implements PostService {
    final Logger log = Logger.getLogger(PostServiceImpl.class);

    @Autowired
    private PostDAO<PostEntity> postDAO;

    @Autowired
    private UserDAO<UserEntity> userDAO;

    @Autowired
    NotificationServiceImpl notificationService;

    @Autowired
    private ApplicationEventPublisher applicationEventPublisher;

    @Override
    public PostEntity save(CreatePostReq req, int userId) {
        int id = 0;
        try {

            UserEntity check = userDAO.findByIdAndRole(userId);
            if (check != null) {
                PostEntity post = PostConverter.toEntity(req);
                post.setCreatedBy(userId);
                post.setUpdatedBy(userId);
                post.setDel(false);
                post.setApproved(false);
                post.setNotApproved(false);
                id = postDAO.save(post);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return postDAO.findById(id);
    }

    @Override
    public PostEntity update(CreatePostReq req, int userId) {
        PostEntity post = PostConverter.toEntity(req);
        post.setUpdatedBy(userId);
        postDAO.update(post);
        return post;
    }

    @Override
    public void delete(int id) {
        try {
            postDAO.delete(id);
        } catch (Exception e) {
            e.printStackTrace();
            log.error(e.getMessage());
        }
    }

    @Override
    public PostEntity findById(int id) {
        return postDAO.findById(id);
    }

    @Override
    public List<PostEntity> findAll() {
        return postDAO.findAll();
    }

    @Override
    public List<PostEntity> getPostByUserId(int userId, Authentication auth) {
        UserEntity user = userDAO.findByIdAndRole(userId);
        List<PostEntity> post;
        if (user != null) {
            if (auth == null || !user.getEmail().equals(auth.getName())) {
                post = postDAO.findAllByUserEmailAndDelAndApproved(user.getEmail(), false, true);
            } else {
                post = postDAO.findByUser(user);
            }
        } else {
            throw new NotFoundException("No found UserId");
        }
        return post;
    }

    @Override
    public PostEntity approvePost(int idPost, String usernameApproved, boolean isApprove) {
        try {
            PostEntity post = postDAO.findById(idPost);
            if (post == null) {
                throw new NotFoundException("Không tìm thấy post id " + idPost);
            }
            if (isApprove) {
                UserEntity user = userDAO.findByEmail(usernameApproved);
                post.setApproved(true);
                post.setNotApproved(false);
                post.setUpdatedBy(user.getId());
//                actionService.createAction(post.get(), user.get(), ActionName.APPROVE);
                applicationEventPublisher.publishEvent(new NotificationEvent(this, post));
//                createNoti(post.get());
            } else {
                UserEntity user = userDAO.findByEmail(usernameApproved);
                post.setNotApproved(true);
                post.setApproved(false);
                post.setUpdatedBy(user.getId());
//                actionService.createAction(post.get(), user.get(), ActionName.BLOCK);
                applicationEventPublisher.publishEvent(new NotificationEvent(this, post));
            }
            postDAO.update(post);
            return post;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
