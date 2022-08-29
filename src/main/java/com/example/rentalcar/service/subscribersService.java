package com.example.rentalcar.service;

import com.example.rentalcar.model.SubscribersEntity;

import java.util.List;

public interface subscribersService {
    //thêm
    void saveSubscribers(SubscribersEntity sb);

    //lấy tất cả
    List<SubscribersEntity> listsSubscribers();

    //tìm theo id
    SubscribersEntity findSbById(Long id);

    //delete
    void deleteSb(Long id);


}
