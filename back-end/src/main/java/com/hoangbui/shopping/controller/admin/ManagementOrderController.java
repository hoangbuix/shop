package com.hoangbui.shopping.controller.admin;

import com.hoangbui.shopping.entity.OrderEntity;
import com.hoangbui.shopping.model.req.create.CreateOrderReq;
import com.hoangbui.shopping.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/admin/order")
@CrossOrigin(origins = "*")
public class ManagementOrderController {

     @Autowired
     private OrderService orderService;

     @PostMapping("/create")
     private ResponseEntity<?> createOrder(@RequestBody CreateOrderReq req) {
          OrderEntity order = orderService.save(req);
          return new ResponseEntity<>(order, HttpStatus.OK);
     }

     @PostMapping("/check")
     private ResponseEntity<?> checkTotalProduct() {

          return new ResponseEntity<>("", HttpStatus.OK);
     }
}
