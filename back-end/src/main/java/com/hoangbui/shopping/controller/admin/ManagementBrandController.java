package com.hoangbui.shopping.controller.admin;

import com.hoangbui.shopping.entity.BrandEntity;
import com.hoangbui.shopping.exception.DuplicateRecordException;
import com.hoangbui.shopping.model.req.create.CreateBrandReq;
import com.hoangbui.shopping.service.BrandService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/admin/brand")
@CrossOrigin(origins = "*")
public class ManagementBrandController {
    final Logger log = Logger.getLogger(ManagementBrandController.class);

    @Autowired
    private BrandService brandService;

    @PostMapping("/create")
    private ResponseEntity<?> create(@RequestBody CreateBrandReq req) {
        BrandEntity brn = brandService.findByBrandName(req.getBrandName());
        if (brn != null) {
            throw new DuplicateRecordException("Đã tồn tại");
        } else {
            BrandEntity brand = brandService.save(req);
            return new ResponseEntity<>(brand, HttpStatus.OK);
        }
    }
}
