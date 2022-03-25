package com.hoangbui.shopping.controller.admin;

import com.hoangbui.shopping.entity.CategoryEntity;
import com.hoangbui.shopping.exception.DuplicateRecordException;
import com.hoangbui.shopping.model.req.create.CreateCategoryReq;
import com.hoangbui.shopping.service.CategoryService;
import com.hoangbui.shopping.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;

@RestController
@RequestMapping("/api/v1/admin/category")
@CrossOrigin(origins = "*")
public class ManagementCategoryController {
    @Autowired
    private ProductService productService;

    @Autowired
    private CategoryService categoryService;

    @PostMapping("/create")
    private ResponseEntity<?> create(@RequestBody CreateCategoryReq req) {
        CategoryEntity cate;
        CategoryEntity code = categoryService.findByCode(req.getCategoryCode());
        if (code != null) {
            throw new DuplicateRecordException("Category exist");
        } else {
             cate = categoryService.save(req);
        }
        return new ResponseEntity<>(cate, HttpStatus.OK);
    }

}
