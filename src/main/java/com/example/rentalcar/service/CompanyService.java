package com.example.rentalcar.service;

import com.example.rentalcar.model.CompanyEntity;

import java.util.List;

public interface CompanyService {
    void saveCompany(CompanyEntity company);


    //lấy tất cả
    List<CompanyEntity> listsCompany();

    //tìm theo id
    CompanyEntity findCompanyById(Long id);

    //delete
    void deleteCompany(Long id);
}
