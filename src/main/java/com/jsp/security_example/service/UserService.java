package com.jsp.security_example.service;

import com.jsp.security_example.model.User;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

public interface UserService {

    public String greeting();

    public User signup( User user) ;

    public String signin( String username,  String password);
}
