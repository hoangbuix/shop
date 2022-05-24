package com.hoangbui.shopping.controller.anonymous;

import com.hoangbui.shopping.entity.CategoryEntity;
import com.hoangbui.shopping.service.CategoryService;
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
@RequestMapping(API_ANONYMOUS + "/category")
@CrossOrigin(origins = "*")
@Slf4j
@Api(value = "Shop", description = "Xem category")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @ApiOperation(value = "Xem toan bo category")
    @GetMapping(FIND_ALL)
    private ResponseEntity<?> findAll() {
        List<CategoryEntity> cate = categoryService.findAll();
        return new ResponseEntity<>(cate.isEmpty() ? null : cate, HttpStatus.OK);
    }


    @ApiOperation(value = "Xem thể loại sản phầm")
    @GetMapping(FIND_BY_ID+"/{id}")
    private ResponseEntity<?> findById(@PathVariable int id) {
        CategoryEntity cate = categoryService.findById(id);
        return new ResponseEntity<>(cate, HttpStatus.OK);
    }


}
