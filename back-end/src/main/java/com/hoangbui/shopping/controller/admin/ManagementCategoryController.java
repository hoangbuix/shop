package com.hoangbui.shopping.controller.admin;

import com.hoangbui.shopping.entity.CategoryEntity;
import com.hoangbui.shopping.exception.DuplicateRecordException;
import com.hoangbui.shopping.model.req.create.CreateCategoryReq;
import com.hoangbui.shopping.model.req.update.UpdateCategoryReq;
import com.hoangbui.shopping.service.CategoryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

import static com.hoangbui.shopping.util.PathUrl.CREATE;
import static com.hoangbui.shopping.util.PathUrl.UPDATE;


@RestController
@RequestMapping("/api/v1/admin/category")
@CrossOrigin(origins = "*")
@Slf4j
public class ManagementCategoryController {
    @Autowired
    private CategoryService categoryService;

    @PostMapping(CREATE)
    private ResponseEntity<?> create(@Valid @RequestBody CreateCategoryReq req) {
        CategoryEntity cate = null;
        CategoryEntity check = categoryService.findByCode(req.getCategoryCode());
        if (check == null) {
            cate = categoryService.save(req);
        } else {
            throw new DuplicateRecordException("Da ton tai!");
        }
        return new ResponseEntity<>(cate, HttpStatus.OK);
    }

    @PutMapping(UPDATE)
    private ResponseEntity<?> update(@Valid @RequestBody UpdateCategoryReq req) {
        CategoryEntity cate = null;
        try {
            cate = categoryService.update(req);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>(cate, HttpStatus.OK);
    }


    @DeleteMapping("/delete/{id}")
    private ResponseEntity<?> delete(@PathVariable int id) {
        try {
            categoryService.delete(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>("Delete category success!", HttpStatus.OK);
    }

    @GetMapping("/findAll")
    private ResponseEntity<?> findAll() {
        List<CategoryEntity> cate = categoryService.findAll();
        return new ResponseEntity<>(cate.isEmpty() ? null : cate, HttpStatus.OK);
    }

}
