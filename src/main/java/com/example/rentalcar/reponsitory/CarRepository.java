package com.example.rentalcar.reponsitory;

import com.example.rentalcar.dto.CarInfo;
import com.example.rentalcar.model.CarEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.data.domain.Pageable;


import java.util.List;

@Repository
public interface CarRepository extends JpaRepository<CarEntity,Long> {

    @Query("SELECT new com.example.rentalcar.dto.CarInfo(" +
    "car.id,car.name,car.carnumber,car.priceperday,car.description,car.companyId,car.seatcapacity," +
            "car.fuletype,car.modelyear,car.thumbnail,car.status,com.name) FROM CarEntity car join CompanyEntity com on car.companyId = com.id")
    List<CarInfo> findAllCarInfo();

//    Page<CarInfo> findAllCarPage(Pageable pageable);
    @Query("SELECT new com.example.rentalcar.model.CarEntity(" +
            "c.id,c.name,c.carnumber,c.priceperday,c.description,c.companyId,c.seatcapacity,c.fuletype,c.modelyear,c.thumbnail,c.status)FROM CarEntity c where c.name like %?1%")
    List<CarEntity> searchCarByName(String name);
}
