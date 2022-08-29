package com.example.rentalcar.service;

import com.example.rentalcar.model.SubscribersEntity;
import com.example.rentalcar.reponsitory.subscribersRepon;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class subscribersServiceIpl implements subscribersService {
    @Autowired
    subscribersRepon subscriberRepon;
    @Override
    public void saveSubscribers(SubscribersEntity sb) {
        subscriberRepon.save(sb);
    }

    @Override
    public List<SubscribersEntity> listsSubscribers() {
        return subscriberRepon.findAll();
    }

    @Override
    public SubscribersEntity findSbById(Long id) {
        return subscriberRepon.findById(id).get();
    }

    @Override
    public void deleteSb(Long id) {
        subscriberRepon.deleteById(id);
    }
}
