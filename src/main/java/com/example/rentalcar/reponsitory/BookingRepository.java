package com.example.rentalcar.reponsitory;

import com.example.rentalcar.dto.BookingCarDetail;
import com.example.rentalcar.dto.BookingCarUserDetail;
import com.example.rentalcar.dto.CarInfo;
import com.example.rentalcar.model.BookingEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookingRepository extends JpaRepository<BookingEntity,Long> {

    @Query("SELECT new com.example.rentalcar.dto.BookingCarDetail (" +
            "b.id,c.name,c.carnumber,b.pricePerDay,c.description,c.seatcapacity,c.fuletype,c.modelyear,c.thumbnail,c.id,b.fromDate," +
            "b.toDate,b.note,b.invoice,b.status) FROM CarEntity c join BookingEntity b on c.id = b.carId where b.id = ?1")
    BookingCarDetail findByIdBookingCarDetail(Long id);

    List<BookingEntity> findByUserId(Long id);

    @Query("SELECT NEW com.example.rentalcar.dto.BookingCarUserDetail(" +
            "b.id,c.name,c.carnumber,b.pricePerDay,c.description,c.seatcapacity,c.fuletype,c.modelyear,c.thumbnail,c.id,b.fromDate," +
            "b.toDate,b.note,b.invoice,b.status,u.name,u.address,u.email,u.telephone,u.cmt,u.passport,u.avatar,b.createdAt) FROM BookingEntity b join CarEntity c on b.carId = c.id join UsersEntity u on b.userId = u.id where b.status = ?1")
    List<BookingCarUserDetail> findByStatusBookingCarUserDetail(Integer status);



}
