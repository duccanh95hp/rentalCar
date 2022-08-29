package com.example.rentalcar.service;

import com.example.rentalcar.dto.BookingCarDetail;
import com.example.rentalcar.dto.BookingCarUserDetail;
import com.example.rentalcar.model.BookingEntity;
import com.example.rentalcar.reponsitory.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookingServiceImpl implements BookingService{
    @Autowired
    BookingRepository bookingRepository;
    @Override
    public void saveBooking(BookingEntity booking) {
        bookingRepository.save(booking);
    }

    @Override
    public List<BookingEntity> listsBooking() {
        return bookingRepository.findAll();
    }

    @Override
    public BookingEntity findBookingById(Long id) {
        return bookingRepository.findById(id).get();
    }

    @Override
    public void deleteBooking(Long id) {
        bookingRepository.deleteById(id);
    }

    @Override
    public List<BookingEntity> listByUserId(Long id) {
        return bookingRepository.findByUserId(id);
    }

    @Override
    public BookingCarDetail findBookingCarDetail(Long id) {
        return bookingRepository.findByIdBookingCarDetail(id);
    }

    @Override
    public List<BookingCarUserDetail> findByStatusBookingCarUserDetail(Integer status) {
        return bookingRepository.findByStatusBookingCarUserDetail(status);
    }
}
