package com.hoangbui.shopping.controller.admin;

import com.hoangbui.shopping.entity.ProductEntity;
import com.hoangbui.shopping.model.req.create.CreateProductReq;
import com.hoangbui.shopping.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/v1/admin/product")
@CrossOrigin(origins = "*")
//@CrossOrigin(methods = {RequestMethod.GET, RequestMethod.PUT, RequestMethod.POST, RequestMethod.DELETE}, allowCredentials = "true", origins = "*", maxAge = 3600)
public class ManagementProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/check")
    private ResponseEntity<?> checkTotalProduct() {
        int count = productService.checkTotalProduct();
        return new ResponseEntity<>(count, HttpStatus.OK);
    }

    @GetMapping("/findAll")
    private ResponseEntity<?> getAllProduct() {
        try {
            List<ProductEntity> products = productService.findAll();
            return new ResponseEntity<>(products, HttpStatus.CREATED);
        }catch (Exception e) {
            log.error("Create Cart method error {}", e.getMessage(), e);
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

//    @Secured("ROLE_ADMIN")
//    @PreAuthorize("hasRole('admin')")
    @GetMapping("/findById/{id}")
    private ResponseEntity<?> getById(@PathVariable int id) {
        ProductEntity product = productService.findById(id);
        return new ResponseEntity<>(product, HttpStatus.OK);
    }

    @PostMapping("/create")
    private ResponseEntity<?> create(@RequestBody CreateProductReq req) {
        ProductEntity product = productService.save(req);
        return new ResponseEntity<>(product, HttpStatus.OK);
    }

}
