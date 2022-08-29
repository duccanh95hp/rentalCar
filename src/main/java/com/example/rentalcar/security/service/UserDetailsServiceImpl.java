package com.example.rentalcar.security.service;

import com.example.rentalcar.model.RolesEntity;
import com.example.rentalcar.model.UsersEntity;
import com.example.rentalcar.reponsitory.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    UserRepository userRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UsersEntity users = userRepository.findByName(username);

        List<GrantedAuthority> grantList = new ArrayList<GrantedAuthority>();
        if(users == null){
            new UsernameNotFoundException("Login fail");
        }else {
           List<GrantedAuthority> authority = users.getRoles().stream()
                   .map(role -> new SimpleGrantedAuthority(role.getName()))
                   .collect(Collectors.toList());

            UserDetails userDetails = new org.springframework.security.core.userdetails.User(username,users.getPassword(),authority);
            return userDetails;
        }

        return UserDetailsImpl.build(users);
    }
}
