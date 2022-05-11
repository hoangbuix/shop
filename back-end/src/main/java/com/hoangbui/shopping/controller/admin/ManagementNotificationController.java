package com.hoangbui.shopping.controller.admin;

import com.hoangbui.shopping.common.controller.UploadFileController;
import com.hoangbui.shopping.common.message.ResponseMessage;
import com.hoangbui.shopping.service.NotificationService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/admin/notification")
@CrossOrigin(origins = "*")
@Slf4j
@Api(value = "Shop", description = "Quản lý thông báo")
public class ManagementNotificationController {
    @Autowired
    private NotificationService notificationService;

    @ApiOperation(value = "Lấy một trang thông báo của người dùng")
    @GetMapping("/notification")
    public ResponseEntity<?> getNotificationByEmail(Authentication auth, @RequestParam("screen") boolean screen) {
        return new ResponseEntity<>(notificationService.getNotificationByEmail(auth.getName(), screen), HttpStatus.OK);
    }


    @ApiOperation(value = "Đánh dấu thông báo đã xem")
    @PutMapping("/notification/{id}")
    public ResponseEntity<?> seenNotification(@PathVariable int id) {
        return new ResponseEntity<>(notificationService.sendNotification(id), HttpStatus.OK);
    }
}
