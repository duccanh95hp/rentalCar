package com.example.rentalcar.reponsitory;

import com.example.rentalcar.model.SubscribersEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface subscribersRepon extends JpaRepository<SubscribersEntity,Long> {
}
