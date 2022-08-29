package com.example.rentalcar.service;

import com.example.rentalcar.dto.CarInfo;
import com.example.rentalcar.model.CarEntity;
import com.example.rentalcar.reponsitory.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


import java.util.List;
@Service
public class CarServiceImpl implements CarService{
    @Autowired
    CarRepository carRepository;

    @Override
    public void saveCar(CarEntity car) {
        carRepository.save(car);
    }

    @Override
    public List<CarEntity> listsCar() {
        return carRepository.findAll();
    }

    @Override
    public CarEntity findCarById(Long id) {
        return carRepository.findById(id).get();
    }

    @Override
    public void deleteCar(Long id) {
        carRepository.deleteById(id);
    }

    @Override
    public List<CarInfo> findAllCarInfo() {
        return carRepository.findAllCarInfo();
    }

    @Override
    public List<CarEntity> searchCarByName(String name) {
        return carRepository.searchCarByName(name);
    }

//    @Override
//    public Page<CarInfo> findCar(Pageable pageable) {
//        return carRepository.findAllCarPage(pageable);
//    }


}
