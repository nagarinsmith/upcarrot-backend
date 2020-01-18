package com.upcarrot.UpCarrot.Controller;

import com.upcarrot.UpCarrot.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public ResponseEntity register(
            @RequestParam String email,
            @RequestParam String password
    ) {
        userService.register(email, password);
        return new ResponseEntity<>("Welcome!", HttpStatus.OK);
    }
}
