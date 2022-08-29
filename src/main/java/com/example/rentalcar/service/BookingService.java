package com.example.rentalcar.service;

import com.example.rentalcar.dto.BookingCarDetail;
import com.example.rentalcar.dto.BookingCarUserDetail;
import com.example.rentalcar.model.BookingEntity;

import java.util.List;

public interface BookingService {
    void saveBooking(BookingEntity booking);


    //lấy tất cả
    List<BookingEntity> listsBooking();

    //tìm theo id
    BookingEntity findBookingById(Long id);

    //delete
    void deleteBooking(Long id);

    List<BookingEntity> listByUserId(Long id);

    BookingCarDetail findBookingCarDetail(Long id);

    List<BookingCarUserDetail> findByStatusBookingCarUserDetail(Integer status);
}
