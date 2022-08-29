package com.example.rentalcar.controller.view.admin;

import com.example.rentalcar.dto.CarInfo;
import com.example.rentalcar.model.CarEntity;
import com.example.rentalcar.model.CompanyEntity;
import com.example.rentalcar.service.CarService;
import com.example.rentalcar.service.CompanyService;
import com.example.rentalcar.service.FileStorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping(value = "")
public class carController {
    @Autowired
    CarService carService;

    @Autowired
    FileStorageService storageService;
    @Autowired
    CompanyService companyService;
    @GetMapping(value = "/admin/car")
    public String showCars(Model model){
        List<CarInfo> cars = carService.findAllCarInfo();
        List<CompanyEntity> companys = companyService.listsCompany();
        model.addAttribute("cars",cars);
        model.addAttribute("companys",companys);
        return "adminlte/car/list";
    }
    //delete
    @GetMapping("/admin/car/delete/{id}")
    public String deleteCar(@PathVariable("id") long id) {

        carService.deleteCar(id);
        return "redirect:/admin/car";
    }
    //add
    @PostMapping("/admin/car/save")
    public String addCar(
                         @RequestParam(value = "file") MultipartFile file,
                         @RequestParam("name") String name,
                         @RequestParam("carnumber") String carnumber,
                         @RequestParam("priceperday") Integer priceperday,
                         @RequestParam("description") String description,
                         @RequestParam("company_id") Long company_id,
                         @RequestParam("seatcapacity") Integer seatcapacity,
                         @RequestParam("fuletype") String fuletype,
                         @RequestParam("modelyear") Integer modelyear,
                         @RequestParam("status") Integer status) {

        String path = storageService.storeFile(file);
        String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path("/api/downloadFile/")
                .path(path)
                .toUriString();
       CarEntity car = new CarEntity();
       car.setName(name);
       car.setCarnumber(carnumber);
       car.setPriceperday(priceperday);
       car.setDescription(description);
       car.setCompanyId(company_id);
       car.setSeatcapacity(seatcapacity);
       car.setFuletype(fuletype);
       car.setModelyear(modelyear);
       car.setStatus(status);
       car.setThumbnail(fileDownloadUri);
       carService.saveCar(car);
        return "redirect:/admin/car";
    }
    //edit form
    @GetMapping("/admin/car/edit/{id}")
    public String showUpdateForm(@PathVariable("id") long id, Model model) {
        CarEntity car = carService.findCarById(id);
        List<CompanyEntity> companys = companyService.listsCompany();
        model.addAttribute("car", car);
        model.addAttribute("companys",companys);
        return "adminlte/car/edit";
    }
    //update
    @PostMapping("/admin/car/update/{id}")
    public String updateCar(@PathVariable("id") long id,
                            @RequestParam(value = "file") MultipartFile file,
                            @RequestParam("name") String name,
                            @RequestParam("carnumber") String carnumber,
                            @RequestParam("priceperday") Integer priceperday,
                            @RequestParam("description") String description,
                            @RequestParam("company_id") Long company_id,
                            @RequestParam("seatcapacity") Integer seatcapacity,
                            @RequestParam("fuletype") String fuletype,
                            @RequestParam("modelyear") Integer modelyear,
                            @RequestParam("status") Integer status) {

        String path = storageService.storeFile(file);
        String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path("/api/downloadFile/")
                .path(path)
                .toUriString();
        CarEntity car = carService.findCarById(id);
        car.setName(name);
        car.setCarnumber(carnumber);
        car.setPriceperday(priceperday);
        car.setDescription(description);
        car.setCompanyId(company_id);
        car.setSeatcapacity(seatcapacity);
        car.setFuletype(fuletype);
        car.setModelyear(modelyear);
        car.setStatus(status);
        car.setThumbnail(fileDownloadUri);
        carService.saveCar(car);
        return "redirect:/admin/car";
    }

    @GetMapping("/car/searchCar/{name}")
    public String searchCar(@PathVariable String name,
                            Model model){
        List<CarEntity> cars = carService.searchCarByName(name);
        model.addAttribute("cars",cars);
        return "web/searchCar";
    }

}
