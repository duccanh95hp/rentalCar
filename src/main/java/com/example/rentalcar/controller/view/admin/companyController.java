package com.example.rentalcar.controller.view.admin;

import com.example.rentalcar.model.CompanyEntity;
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
@RequestMapping(value = "/admin/company")
public class companyController {
    @Autowired
    CompanyService companyService;
    @Autowired
    FileStorageService storageService;
    @GetMapping(value = "")
    public String showCompany(Model model){
        List<CompanyEntity> companys = companyService.listsCompany();
        model.addAttribute("companys",companys);
        return "adminlte/company/list";
    }
    //delete
    @GetMapping("/delete/{id}")
    public String deleteCompany(@PathVariable("id") long id) {

        companyService.deleteCompany(id);
        return "redirect:/admin/company";
    }
    //add
    @PostMapping("/save")
    public String addCompany(@RequestParam(value = "file") MultipartFile file,
                             @RequestParam("name") String name,
                             @RequestParam("country") String country,
                             @RequestParam("telephone") String telephone,
                             @RequestParam("status") Integer status) {
        String path = storageService.storeFile(file);
        String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path("/api/downloadFile/")
                .path(path)
                .toUriString();
        CompanyEntity company = new CompanyEntity();
        company.setName(name);
        company.setCountry(country);
        company.setTelephone(telephone);
        company.setStatus(status);
        company.setImage(fileDownloadUri);
        companyService.saveCompany(company);
        return "redirect:/admin/company";
    }
    //edit form
    @GetMapping("/edit/{id}")
    public String showUpdateForm(@PathVariable("id") long id, Model model) {
        CompanyEntity company = companyService.findCompanyById(id);

        model.addAttribute("company", company);
        return "adminlte/company/edit";
    }
    //update
    @PostMapping("/update/{id}")
    public String updateCompany(@PathVariable("id") long id,
                                @RequestParam(value = "file") MultipartFile file,
                                @RequestParam("name") String name,
                                @RequestParam("country") String country,
                                @RequestParam("telephone") String telephone,
                                @RequestParam("status") Integer status) {
        String path = storageService.storeFile(file);
        String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path("/api/downloadFile/")
                .path(path)
                .toUriString();
        CompanyEntity company =companyService.findCompanyById(id);
        company.setName(name);
        company.setCountry(country);
        company.setTelephone(telephone);
        company.setStatus(status);
        company.setImage(fileDownloadUri);
        companyService.saveCompany(company);
        return "redirect:/admin/company";
    }
}
