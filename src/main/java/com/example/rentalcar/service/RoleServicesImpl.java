package com.example.rentalcar.service;

import com.example.rentalcar.model.RolesEntity;
import com.example.rentalcar.reponsitory.RoleReponsitory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class RoleServicesImpl implements RoleServices{

    @Autowired
    RoleReponsitory repository;
    @Override
    public Optional<RolesEntity> findByName(String name) {
        return repository.findByName(name);
    }
}
