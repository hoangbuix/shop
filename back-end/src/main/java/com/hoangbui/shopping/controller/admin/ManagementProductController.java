package com.hoangbui.shopping.controller.admin;


import com.hoangbui.shopping.entity.ProductEntity;
import com.hoangbui.shopping.model.req.create.CreateProductReq;
import com.hoangbui.shopping.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/admin/product")
@CrossOrigin(origins = "*")
public class ManagementProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/check")
    private ResponseEntity<?> checkTotalProduct() {
        int count = productService.checkTotalProduct();
        return new ResponseEntity<>(count,HttpStatus.OK);
    }

    @GetMapping("/get")
    private ResponseEntity<?> getAllProduct() {
        List<ProductEntity> products =  productService.findAll();
        return new ResponseEntity<>(products, HttpStatus.OK);
    }

    @GetMapping("get-id/{id}")
    private ResponseEntity<?> getById(@PathVariable  int id) {
        ProductEntity product = productService.findById(id);
        return new ResponseEntity<>(product, HttpStatus.OK);
    }

    @PostMapping("/create")
    private ResponseEntity<?> create(@RequestBody CreateProductReq req) {
        ProductEntity product = productService.save(req);
        return new ResponseEntity<>(product, HttpStatus.OK);
    }

}
