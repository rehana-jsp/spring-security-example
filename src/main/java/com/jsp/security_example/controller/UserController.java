package com.jsp.security_example.controller;


import com.jsp.security_example.model.User;
import com.jsp.security_example.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {
  private final   UserService userService;

    @GetMapping
    public String greeting() {
        return userService.greeting();
    }

    @PostMapping("/signup")
    public User signup(@RequestBody User user) {
        return userService.signup(user);
    }

    @PostMapping("/signin")
    public String signin(@RequestHeader String username, @RequestHeader String password) {
        return userService.signin(username, password);
    }

    public String getCsrfToken(HttpServletRequest request){
        return request.getAttribute("_csrf").toString();
    }
}
