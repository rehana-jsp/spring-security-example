package com.jsp.security_example.audit;

import org.springframework.data.domain.AuditorAware;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import java.util.Optional;


@Component
public class AuditAwareImp implements AuditorAware<String> {

    @Override
    public Optional<String> getCurrentAuditor() {
//        return Optional.of("user");

        Authentication authentication= SecurityContextHolder.getContext().getAuthentication();
        if(authentication==null){
            return Optional.of("SYSTEM");
        }
        return Optional.of(authentication.getName());
    }
}
