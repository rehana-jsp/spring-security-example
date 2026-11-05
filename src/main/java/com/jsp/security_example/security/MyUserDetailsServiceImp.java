package com.jsp.security_example.security;

import com.jsp.security_example.exception.InvalidUserNameException;
import com.jsp.security_example.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class MyUserDetailsServiceImp implements UserDetailsService {

    private final UserRepository  userRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
      UserDetails userDetails = userRepository.findByUsername(username).orElseThrow(
                () -> new InvalidUserNameException("invalid username")
        );

        return userDetails;
    }
}
