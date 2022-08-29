package com.example.rentalcar.controller.view.web;

import com.example.rentalcar.dto.CarInfo;
import com.example.rentalcar.model.BookingEntity;
import com.example.rentalcar.model.CarEntity;
import com.example.rentalcar.model.UsersEntity;
import com.example.rentalcar.service.BookingService;
import com.example.rentalcar.service.CarService;
import com.example.rentalcar.service.userSerice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
public class WebHomeController {
    @Autowired
    CarService carService;
    @Autowired
    userSerice userSerice;
    @Autowired
    BookingService bookingService;
    @GetMapping(value = "")
    public String indexWeb(Model model){
        List<CarInfo> cars = carService.findAllCarInfo();
        List<CarInfo> carHomes = new ArrayList<>();
        carHomes.add(cars.get(0));
        carHomes.add(cars.get(1));
        carHomes.add(cars.get(2));
        carHomes.add(cars.get(3));
        model.addAttribute("cars",carHomes);
        return "web/index";
    }
    @GetMapping(value = "/about")
    public String aboutWeb(){
        return "web/about";
    }
    @GetMapping(value = "/blog")
    public String blogWeb(){
        return "web/blog";
    }
    @GetMapping(value = "/blogSingle")
    public String blogSingleWeb(){
        return "web/blog-single";
    }
    @GetMapping(value = "/car")
    public String carWeb(Model model
    ){
//        Page<CarInfo> pagination = carService.findCar(PageRequest.of(page - 1, limit));
        List<CarInfo> cars = carService.findAllCarInfo();
        model.addAttribute("cars",cars);
//        model.addAttribute("listVehicle", pagination);
//        model.addAttribute("page", page);
//        model.addAttribute("limit", limit);
        return "web/car";
    }
    @GetMapping(value = "/carDetail/{id}")
    public String carSingleWeb(@PathVariable("id") long id, Model model){
        CarEntity car = carService.findCarById(id);
        model.addAttribute("car",car);
        return "web/car-single";
    }
    @GetMapping(value = "/contact")
    public String contactWeb(){
        return "web/contact";
    }
    @GetMapping(value = "/pricing")
    public String pricingWeb(){
        return "web/pricing";
    }
    @GetMapping(value = "/services")
    public String servicesWeb(){
        return "web/services";
    }


    @GetMapping(value = "/booking/{id}")
    public String bookingCar(@PathVariable("id") long id, Model model){
        CarEntity car = carService.findCarById(id);
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
        UsersEntity user = userSerice.findByUsername(username);
        model.addAttribute("car",car);
        model.addAttribute("user",user);
        return "web/booking";
    }

    @GetMapping(value = "/personal")
    public String personal(Model model){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
        UsersEntity user = userSerice.findByUsername(username);
        List<BookingEntity> bookings = bookingService.listByUserId(user.getId());
        model.addAttribute("user",user);
        model.addAttribute("bookings",bookings);
        return "web/personal";
    }
}
