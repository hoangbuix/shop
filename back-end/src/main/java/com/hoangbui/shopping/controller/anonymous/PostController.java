package com.hoangbui.shopping.controller.anonymous;


import com.hoangbui.shopping.entity.PostEntity;
import com.hoangbui.shopping.service.PostService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.hoangbui.shopping.util.PathUrl.*;

@RestController
@RequestMapping(API_ANONYMOUS + "/post")
@CrossOrigin(origins = "*")
@Slf4j
@Api(value = "Shop", description = "Xem tin")
public class PostController {
    @Autowired
    private PostService postService;

    @ApiOperation(value = "Tất cả tin mới")
    @GetMapping(FIND_ALL)
    private ResponseEntity<?> findAll(){
        List<PostEntity> post = postService.findAll();
        return new ResponseEntity<>(post, HttpStatus.OK);
    }

    @ApiOperation(value = "TÌm tin theo Id")
    @GetMapping(FIND_BY_ID + "/{id}")
    private ResponseEntity<?> findById(@PathVariable int id){
        PostEntity post = postService.findById(id);
        return new ResponseEntity<>(post, HttpStatus.OK);
    }
}
