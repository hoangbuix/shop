package com.hoangbui.shopping.model.mapper;

import com.hoangbui.shopping.entity.PostEntity;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PostMapper implements RowMapper<PostEntity> {
    @Override
    public PostEntity mapRow(ResultSet resultSet) {
        PostEntity post = new PostEntity();
        try {
            post.setId(resultSet.getInt("id"));
            post.setContent(resultSet.getString("content"));
            post.setTitle(resultSet.getString("title"));
            post.setThumbnail(resultSet.getString("thumbnail"));
            post.setSlug(resultSet.getString("slug"));
            post.setDescription(resultSet.getString("description"));
            post.setApproved(resultSet.getBoolean("approved"));
            post.setDel(resultSet.getBoolean("del"));
            post.setNotApproved(resultSet.getBoolean("not_approved"));
            post.setActiveFlag(resultSet.getInt("active_flag"));
            post.setCreatedBy(resultSet.getInt("created_by"));
            post.setUpdatedBy(resultSet.getInt("updated_by"));
            post.setCreatedDate(resultSet.getDate("created_date"));
            post.setUpdatedDate(resultSet.getDate("updated_date"));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return post;
    }
}
