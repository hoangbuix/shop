package com.hoangbui.shopping.controller.admin;

import javax.validation.Valid;

import com.hoangbui.shopping.entity.OrderEntity;
import com.hoangbui.shopping.entity.UserEntity;
import com.hoangbui.shopping.model.req.create.CreateOrderReq;
import com.hoangbui.shopping.model.req.update.UpdateOrderReq;
import com.hoangbui.shopping.securiry.CustomUserDetails;
import com.hoangbui.shopping.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/admin/order")
@CrossOrigin(origins = "*")
public class ManagementOrderController {

     @Autowired
     private OrderService orderService;

     @PostMapping("/create")
     private ResponseEntity<?> createOrder(@Valid @RequestBody CreateOrderReq req) {
          UserEntity user = ((CustomUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal())
                    .getUser();
          OrderEntity order = orderService.save(req, user.getId());
          return new ResponseEntity<>(order, HttpStatus.OK);
     }

     @PutMapping("/update")
     private ResponseEntity<?> updateOrder(@Valid @RequestBody UpdateOrderReq req) {
          UserEntity user = ((CustomUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal())
                    .getUser();
          OrderEntity order = orderService.update(req, user.getId());
          return new ResponseEntity<>(order, HttpStatus.OK);
     }

     @GetMapping("/findAll")
     private ResponseEntity<?> findAll() {
          OrderEntity orderEntity = new OrderEntity();
          return new ResponseEntity<>(orderEntity, HttpStatus.OK);
     }

     @PostMapping("/check")
     private ResponseEntity<?> checkTotalProduct() {

          return new ResponseEntity<>("", HttpStatus.OK);
     }
}
