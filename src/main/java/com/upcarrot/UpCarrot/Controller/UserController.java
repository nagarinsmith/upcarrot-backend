package com.upcarrot.UpCarrot.Controller;

import com.upcarrot.UpCarrot.Dto.UserDto;
import com.upcarrot.UpCarrot.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public ResponseEntity register(
            @RequestBody UserDto user
    ) {
        userService.register(user.getUsername(), user.getPassword());
        return new ResponseEntity<>("Welcome!", HttpStatus.OK);
    }
}
