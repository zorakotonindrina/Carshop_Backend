package com.example.Carshop.Configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;

public class CustomAuthenticationManager implements AuthenticationManager {
    private final NoOpPasswordEncoder noOpPasswordEncoder;
    private final CustomUserDetailsService customUserDetailsService;

    public CustomAuthenticationManager(NoOpPasswordEncoder noOpPasswordEncoder,
            CustomUserDetailsService customUserDetailsService) {
        this.noOpPasswordEncoder = noOpPasswordEncoder;
        this.customUserDetailsService = customUserDetailsService;
    }

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String username = authentication.getName();
        String password = authentication.getCredentials().toString();

        UserDetails userDetails = customUserDetailsService.loadUserByUsername(username);
        if (!noOpPasswordEncoder.matches(password, userDetails.getPassword())) {
            throw new BadCredentialsException("Invalid password");
        }

        // Construction d'une AuthenticationToken si l'authentification réussit
        return new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
    }
}
