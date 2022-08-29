package com.example.rentalcar.service;

import com.example.rentalcar.model.UsersEntity;
import com.example.rentalcar.reponsitory.RoleReponsitory;
import com.example.rentalcar.reponsitory.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;

@Service
public class userServiceIpl implements userSerice{
    @Autowired
    UserRepository userRepository;
    @Autowired
    private RoleReponsitory roleRepository;

    @Override
    public void saveUsers(UsersEntity user) {
        userRepository.save(user);
    }



    @Override
    public List<UsersEntity> listsUsers() {
        return userRepository.findAll();
    }

    @Override
    public UsersEntity findUserById(Long id) {
        return userRepository.findById(id).get();
    }

    @Override
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public UsersEntity findByUsername(String name) {
        return userRepository.findByName(name);
    }

    @Override
    public Boolean existsByUsername(String username) {
        return userRepository.existsByName(username);
    }
}
