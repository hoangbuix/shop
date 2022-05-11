package com.hoangbui.shopping.dao.impl;

import com.hoangbui.shopping.dao.PostDAO;
import com.hoangbui.shopping.entity.PostEntity;
import com.hoangbui.shopping.entity.UserEntity;
import com.hoangbui.shopping.model.mapper.PostMapper;
import com.hoangbui.shopping.util.QueryConstant;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import static com.hoangbui.shopping.util.SqlConstant.*;

import java.util.List;

@Component
@Transactional(rollbackFor = Exception.class)
public class PostDAOImpl extends BaseDAOImpl<PostEntity> implements PostDAO<PostEntity> {
    final String POST = "post";

    @Override
    public int save(PostEntity post) {
        return insert(QueryConstant.callQueryUpdate(POST, CREATE, 10), post.getContent(), post.getSlug(),
                post.getTitle(), post.getThumbnail(),
                post.getDescription(), post.isDel(),
                post.isApproved(), post.isNotApproved(),
                post.getCreatedBy(), post.getUpdatedBy());
    }

    @Override
    public void update(PostEntity post) {
        update(QueryConstant.callQueryUpdate(POST, UPDATE, 10), post.getContent(), post.getSlug(),
                post.getTitle(), post.getThumbnail(), post.getDescription(),
                post.isDel(), post.isApproved(), post.isNotApproved(),
                post.getActiveFlag(), post.getUpdatedBy());
    }

    @Override
    public void delete(int id) {
        delete(QueryConstant.callQueryUpdate(POST, DELETE, 1), id);
    }

    @Override
    public List<PostEntity> findAll() {
        return query(QueryConstant.callQueryUpdate(POST, FIND_ALL, 0), new PostMapper());
    }

    @Override
    public PostEntity findById(int id) {
        List<PostEntity> post = query(QueryConstant.callQueryUpdate(POST, FIND_BY_ID,1), new PostMapper(), id);
        return post.isEmpty() ? null : post.get(0);
    }


    @Override
    public List<PostEntity> findAllByUserEmailAndDelAndApproved(String email, boolean del, boolean approve) {
        return null;
    }

    @Override
    public List<PostEntity> findByUser(UserEntity user) {
        return null;
    }
}
