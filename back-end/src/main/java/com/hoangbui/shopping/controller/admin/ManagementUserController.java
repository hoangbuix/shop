package com.hoangbui.shopping.controller.admin;

import com.hoangbui.shopping.entity.UserEntity;
import com.hoangbui.shopping.exception.BadRequestException;
import com.hoangbui.shopping.model.conveter.UserConvert;
import com.hoangbui.shopping.model.dto.CaptchaResponseDTO;
import com.hoangbui.shopping.model.dto.UserDTO;
import com.hoangbui.shopping.model.req.LoginReq;
import com.hoangbui.shopping.model.req.create.CreateUserReq;
import com.hoangbui.shopping.model.req.update.ChangePasswordReq;
import com.hoangbui.shopping.model.req.update.UpdateUserReq;
import com.hoangbui.shopping.securiry.CustomUserDetails;
import com.hoangbui.shopping.securiry.JwtTokenUtil;
import com.hoangbui.shopping.service.UserService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.Collections;
import java.util.List;

import static com.hoangbui.shopping.util.Constant.MAX_AGE_COOKIE;


@RestController
@RequestMapping("/api/v1/admin/user")
@CrossOrigin(origins = "*")
@Api(value = "Shop", description = "Quản lý người dùng")
public class ManagementUserController {

    public static final String CAPTCHA_URL = "https://www.google.com/recaptcha/api/siteverify?secret=%s&response=%s";


    @Autowired
    private static RestTemplate restTemplate;

    @Value("${recaptcha.secret}")
    private String secret;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    private ResponseEntity<?> register(@Valid @RequestBody CreateUserReq req, HttpServletResponse response) {

//        @RequestParam("g-recaptcha-response") String captchaResponse
//        String url = String.format(CAPTCHA_URL, secret, captchaResponse);
//
//        CaptchaResponseDTO res = restTemplate.postForObject(url, Collections.emptyList(), CaptchaResponseDTO.class);
//
//        if (!res.isSuccess()) {
//            throw new BadRequestException("Fill captcha");
//        }


        // Create user
        UserEntity result = userService.save(req);

        // Gen token
        UserDetails principal = new CustomUserDetails(result);
        String token = jwtTokenUtil.generateToken(principal);

        // Add token to cookie to login
        Cookie cookie = new Cookie("JWT_TOKEN", token);
        cookie.setMaxAge(MAX_AGE_COOKIE);
        cookie.setPath("/");
        response.addCookie(cookie);

        return ResponseEntity.ok(UserConvert.toDTO(result));
    }

    @GetMapping("/activate/{code}")
    private ResponseEntity<?> activateEmailCode(@PathVariable String code){
        boolean isActive = userService.activateUser(code);
        if(isActive){
            return new ResponseEntity<>("Access",HttpStatus.ACCEPTED);
        } else {
            throw new BadRequestException("No Access");
        }
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@Valid @RequestBody LoginReq req, HttpServletResponse response) {
        // Authenticate
        try {
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            req.getEmail(),
                            req.getPassword()
                    )
            );
            // Gen token
            String token = jwtTokenUtil.generateToken((CustomUserDetails) authentication.getPrincipal());
            // Add token to cookie to login
            Cookie cookie = new Cookie("JWT_TOKEN", token);
            cookie.setMaxAge(MAX_AGE_COOKIE);
            cookie.setPath("/");
            response.addCookie(cookie);

            return ResponseEntity.ok(UserConvert.toDTO(((CustomUserDetails) authentication.getPrincipal()).getUser()));
        } catch (Exception ex) {
            throw new BadRequestException("Email hoặc mật khẩu không chính xác");
        }
    }



    @PutMapping("/update-profile")
    private ResponseEntity<?> updateProfile(UpdateUserReq req) {
        UserEntity user = ((CustomUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getUser();
        user = userService.update(user, req);
        UserDetails principal = new CustomUserDetails(user);
        Authentication authentication = new UsernamePasswordAuthenticationToken(principal, null, principal.getAuthorities());
        SecurityContextHolder.getContext().setAuthentication(authentication);

        return ResponseEntity.ok("Cập nhật profile thành công");
    }

    @PostMapping("/change-password")
    public ResponseEntity<?> changePassword(@Valid @RequestBody ChangePasswordReq req) {
        UserEntity user = ((CustomUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getUser();
        userService.changePassword(user, req);
        return ResponseEntity.ok("Đổi mật khẩu thành công");
    }

    @GetMapping("/get-all")
    private ResponseEntity<?> findAllUser() {
        List<UserEntity> users = userService.findAll();
        UserDTO userDTO = null;
        for (UserEntity user : users){
          userDTO =   UserConvert.toDTO(user);
        }
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @GetMapping("/get-id/{id}")
    private ResponseEntity<?> findById(@PathVariable(value = "id") int id) {
        UserEntity user = userService.findById(id);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

}
