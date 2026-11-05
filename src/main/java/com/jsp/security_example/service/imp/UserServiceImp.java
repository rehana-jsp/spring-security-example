package com.jsp.security_example.service.imp;


import com.jsp.security_example.model.User;
import com.jsp.security_example.repository.UserRepository;
import com.jsp.security_example.security.JwtService;
import com.jsp.security_example.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImp implements UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    public String greeting() {
        return "Hello World";
    }

    @Override
    public User signup(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

    @Override
    public String signin(String username, String password) {
          User user=userRepository.findByUsername(username).orElseThrow(
                  ()-> new IllegalArgumentException("Username not found!")
          );

        Authentication authentication=
                authenticationManager.authenticate(
                        new UsernamePasswordAuthenticationToken(username, password)
                );

         if ( authentication.isAuthenticated() ) {
             String token =jwtService.generateToken(user);
             return token;
         }
         return "user not found";

    }
}
