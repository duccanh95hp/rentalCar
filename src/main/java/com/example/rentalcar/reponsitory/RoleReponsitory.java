package com.example.rentalcar.reponsitory;

import com.example.rentalcar.model.RolesEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleReponsitory extends JpaRepository<RolesEntity,Long> {
    Optional<RolesEntity> findByName(String name);
}
