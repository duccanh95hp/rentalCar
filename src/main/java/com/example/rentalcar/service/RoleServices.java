package com.example.rentalcar.service;

import com.example.rentalcar.model.RolesEntity;

import java.util.Optional;

public interface RoleServices {
    Optional<RolesEntity> findByName(String name);
}
