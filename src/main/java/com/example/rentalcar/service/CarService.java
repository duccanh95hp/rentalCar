package com.example.rentalcar.service;

import com.example.rentalcar.dto.CarInfo;
import com.example.rentalcar.model.CarEntity;
import org.springframework.data.domain.Page;

import org.springframework.data.domain.Pageable;
import java.util.List;

public interface CarService {
    void saveCar(CarEntity car);


    //lấy tất cả
    List<CarEntity> listsCar();

    //tìm theo id
    CarEntity findCarById(Long id);

    //delete
    void deleteCar(Long id);

    List<CarInfo> findAllCarInfo();

//    Page<CarInfo> findCar(Pageable pageable);

    List<CarEntity> searchCarByName(String name);
}
