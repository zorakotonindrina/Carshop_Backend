package com.example.Carshop.Configuration;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.Carshop.Model.Utilisateur;
import com.example.Carshop.Repository.UltilisateurRepository;

@Service
public class CustomUserDetailsService implements UserDetailsService {
    private final UltilisateurRepository dbUserRepository;

    public CustomUserDetailsService(UltilisateurRepository dbUserRepository) {
        this.dbUserRepository = dbUserRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Utilisateur user = dbUserRepository.findByEmail(username);
        if (user == null) {
            throw new UsernameNotFoundException("No user found with email");
        }
        System.out.println(user.getNom());
        System.out.println(user.getId_utilisateur());
        List<String> roles = new ArrayList<>();
        roles.add(user.getRole());
        UserDetails userDetails = User.builder().username(user.getEmail()).password(user.getMdp())
                .roles(roles.toArray(new String[0])).build();
        return userDetails;
        // return new User(user.getUsername(), user.getPassword(),
        // getGrantedAuthorities(user.getRole()));
    }

    private List<GrantedAuthority> getGrantedAuthorities(String role) {
        List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
        authorities.add(new SimpleGrantedAuthority("ROLE_" + role));
        return authorities;
    }

}
