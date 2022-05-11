package com.hoangbui.shopping.model.mapper;

import com.hoangbui.shopping.entity.NotificationEntity;
import com.hoangbui.shopping.entity.PostEntity;
import com.hoangbui.shopping.entity.RoleEntity;
import com.hoangbui.shopping.entity.UserEntity;
import com.hoangbui.shopping.util.NotificationName;

import java.sql.ResultSet;
import java.util.Collections;
import java.util.Objects;

public class NotificationMapper implements RowMapper<NotificationEntity> {
    @Override
    public NotificationEntity mapRow(ResultSet resultSet) {
        try {
            NotificationEntity notification = new NotificationEntity();
            notification.setId(resultSet.getInt("id"));
            notification.setNotificationName(NotificationName.valueOf(resultSet.getString("notification_name")));
            notification.setSeen(resultSet.getBoolean("seen"));
            notification.setActiveFlag(resultSet.getInt("active_flag"));
            notification.setCreatedDate(resultSet.getDate("created_date"));
            notification.setUpdatedDate(resultSet.getDate("updated_date"));
            try {
                if(!Objects.equals(resultSet.getString("content"), "")){
                    PostEntity post = new PostEntity();
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
                    notification.setPost(post);
                }
            } catch (Exception e){
                e.printStackTrace();
            }
            try {
                UserEntity user = new UserEntity();
                user.setId(resultSet.getInt("id"));
                user.setFirstName(resultSet.getString("first_name"));
                user.setLastName(resultSet.getString("last_name"));
                user.setAvatar(resultSet.getString("avatar"));
                user.setUsername(resultSet.getString("user_name"));
                user.setPassword(resultSet.getString("password"));
                user.setEmail(resultSet.getString("email"));
                user.setActiveCode(resultSet.getString("active_code"));
                user.setActiveFlag(resultSet.getInt("active_flag"));
                user.setCreatedDate(resultSet.getDate("created_date"));
                user.setUpdatedDate(resultSet.getDate("updated_date"));
//                try {
//                    if (!Objects.equals(resultSet.getString("role_name"), "")){
//                        RoleEntity role = new RoleEntity();
//                        role.setRoleName(resultSet.getString("role_name"));
//                        user.setRoles(Collections.singleton(role));
//                    }
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }
                notification.setUser(user);
            }catch (Exception e){
                e.printStackTrace();
            }
            return notification;
        } catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
}
