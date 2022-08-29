package com.example.rentalcar.controller.view;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller

public class adminController {
    //trang chu

    @GetMapping(value = {"/admin"})
    String showIndexLte(){
        return "adminlte/home/index";
    }
    @GetMapping(value = "/login")
    String showLogin(){
        return "adminlte/login/index";
    }
    @GetMapping(value = "/logout")
    String logout(){
        return "redirect:/login";
    }
}
