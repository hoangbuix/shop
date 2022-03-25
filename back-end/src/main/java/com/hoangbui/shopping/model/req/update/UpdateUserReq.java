package com.hoangbui.shopping.model.req.update;

import lombok.Data;

@Data
public class UpdateUserReq {
    private String firstName;

    private String lastName;

    private String avatar;

    private String email;
}