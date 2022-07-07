package com.hoangbui.shopping.controller.admin;


import com.hoangbui.shopping.entity.PostEntity;
import com.hoangbui.shopping.entity.UserEntity;
import com.hoangbui.shopping.model.req.create.CreatePostReq;
import com.hoangbui.shopping.securiry.CustomUserDetails;
import com.hoangbui.shopping.service.PostService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

import static com.hoangbui.shopping.util.PathUrl.CREATE;
import static com.hoangbui.shopping.util.PathUrl.FIND_ALL;

@RestController
@RequestMapping("/api/v1/admin/post")
@CrossOrigin(origins = "*")
@Slf4j
@Api(value = "Shop", description = "Quản lý bài viết")
public class ManagementPostController {

    @Autowired
    private PostService postService;

    @ApiOperation(value = "Đăng tin mới")
    @PostMapping(CREATE)
    private ResponseEntity<?> create(@Valid @RequestBody CreatePostReq req) {
        UserEntity user = ((CustomUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal())
                .getUser();
        PostEntity post = postService.save(req, user.getId());
        return new ResponseEntity<>(post, HttpStatus.CREATED);
    }

    @GetMapping(FIND_ALL)
    private ResponseEntity<?> findAll() {
        List<PostEntity> post = postService.findAll();
        return new ResponseEntity<>(post, HttpStatus.OK);
    }

    @ApiOperation(value = "Duyệt/Khóa tin đăng")
    @PutMapping("/post/{id}/approve/{bool}")
    public ResponseEntity<?> approvePostAndLogging(@PathVariable int id, @PathVariable boolean bool) {
        UserEntity user = ((CustomUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal())
                .getUser();
        return new ResponseEntity<>(postService.approvePost(id, user.getEmail(), bool), HttpStatus.OK);
    }

    @ApiOperation(value = "Lấy danh sách tin đăng của một người dùng")
    @GetMapping("/getPostByUserId/{userId}")
    private ResponseEntity<?> findPostByUserId(@Valid @PathVariable int userId, Authentication auth) {
        UserEntity user = ((CustomUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal())
                .getUser();
        List<PostEntity> post = postService.getPostByUserId(userId, auth);
        return new ResponseEntity<>(post, HttpStatus.OK);
    }


}
