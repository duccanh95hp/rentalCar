package com.example.rentalcar.controller.view.admin;

import com.example.rentalcar.dto.BookingCarDetail;
import com.example.rentalcar.dto.BookingCarUserDetail;
import com.example.rentalcar.model.BookingEntity;
import com.example.rentalcar.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.List;
import java.util.Random;

@Controller
@RequestMapping(value = "/booking")
public class bookingController {
    @Autowired
    BookingService bookingService;
    @RequestMapping(value = "/save",method = RequestMethod.POST)
    public String addBooking( @RequestParam("car_id") Long car_id,
                              @RequestParam("user_id") Long user_id,
                              @RequestParam("pricePerDay") Integer pricePerDay,
                              @RequestParam("fromDate") Date fromDate,
                              @RequestParam("toDate") Date toDate,

                              @RequestParam("status") Integer status,
                              @RequestParam("note") String note){
        Date date = Date.valueOf(LocalDate.now());
        int leftLimit = 97; // letter 'a'
        int rightLimit = 122; // letter 'z'
        int len = 5;
        Random random = new Random();
        String generatedString = random.ints(leftLimit, rightLimit + 1)
                .limit(len)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();
        BookingEntity booking = new BookingEntity();
        booking.setCarId(car_id);
        booking.setUserId(user_id);
        booking.setPricePerDay(pricePerDay);

        booking.setFromDate(fromDate);

        booking.setToDate(toDate);
        booking.setStatus(status);
        booking.setNote(note);
        booking.setCreatedAt(date);
        booking.setInvoice(generatedString);
        bookingService.saveBooking(booking);
        return "redirect:/";
    }


    @RequestMapping(value = "/bookingCarDetail/{id}",method = RequestMethod.GET)
    public String bookingCarDetail(@PathVariable("id") long id, Model model){
        BookingCarDetail b = bookingService.findBookingCarDetail(id);
        model.addAttribute("bookDetail",b);
        return "web/bookingCarDetail";
    }
    @RequestMapping(value = "/bookingCarUserDetail/{status}",method = RequestMethod.GET)
    public String bookingCarUserDetail(@PathVariable("status") Integer status, Model model){
        List<BookingCarUserDetail> bookings = bookingService.findByStatusBookingCarUserDetail(status);
        model.addAttribute("bookings",bookings);
        return "adminlte/booking/index";
    }

    @PostMapping("/update/{id}")
    public String updateBooking(@PathVariable Long id,Model model,
                                @RequestParam("status") Integer status){
        BookingEntity b = bookingService.findBookingById(id);
        b.setInvoice(b.getInvoice());
        b.setCarId(b.getCarId());
        b.setUserId(b.getUserId());
        b.setPricePerDay(b.getPricePerDay());
        b.setFromDate(b.getFromDate());
        b.setToDate(b.getToDate());
        b.setNote(b.getNote());
        b.setStatus(status);
        bookingService.saveBooking(b);
        return "redirect:/admin/booking/bookingCarUserDetail/1";
    }
}
