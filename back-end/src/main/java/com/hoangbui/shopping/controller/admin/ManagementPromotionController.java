package com.hoangbui.shopping.controller.admin;

import com.hoangbui.shopping.entity.PromotionEntity;
import com.hoangbui.shopping.model.req.create.CreatePromotionReq;
import com.hoangbui.shopping.service.PromotionService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1/admin/promotion")
@CrossOrigin(origins = "*")
public class ManagementPromotionController {
    final Logger log = Logger.getLogger(ManagementPromotionController.class);

    @Autowired
    private PromotionService promotionService;


    @PostMapping("create")
    private ResponseEntity<?> create(@Valid @RequestBody CreatePromotionReq req) {
        PromotionEntity promotion = promotionService.save(req);
        return new ResponseEntity<>(promotion, HttpStatus.OK);
    }

}
