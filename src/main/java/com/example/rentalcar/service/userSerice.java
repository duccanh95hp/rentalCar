package com.example.rentalcar.service;


import com.example.rentalcar.model.UsersEntity;

import java.util.List;
import java.util.Optional;

public interface userSerice {
    void saveUsers(UsersEntity user);


    //lấy tất cả
    List<UsersEntity> listsUsers();

    //tìm theo id
    UsersEntity findUserById(Long id);

    //delete
    void deleteUser(Long id);

    UsersEntity findByUsername(String name);

    Boolean existsByUsername(String username);
}
