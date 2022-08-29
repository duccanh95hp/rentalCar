package com.example.rentalcar.reponsitory;

import com.example.rentalcar.model.UsersEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository
        extends JpaRepository<UsersEntity, Long> {

   UsersEntity findByName(String username);
   Boolean existsByName(String username);
}
