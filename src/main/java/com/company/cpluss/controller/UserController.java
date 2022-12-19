package com.company.cpluss.controller;

import com.company.cpluss.model.userInfo.User;
import com.company.cpluss.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/signup")
    public ResponseEntity signup(@RequestBody User user){
        return ResponseEntity.ok(userService.signup(user));
    }

    @GetMapping
    public ResponseEntity allUserList(){
        return ResponseEntity.ok(userService.viewUsersList());
    }

}
