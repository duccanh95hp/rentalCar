package com.example.rentalcar.service;

import com.example.rentalcar.model.CompanyEntity;
import com.example.rentalcar.reponsitory.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompanyServiceImpl implements CompanyService {
    @Autowired
    CompanyRepository companyRepository;
    @Override
    public void saveCompany(CompanyEntity company) {
        companyRepository.save(company);
    }

    @Override
    public List<CompanyEntity> listsCompany() {
        return companyRepository.findAll();
    }

    @Override
    public CompanyEntity findCompanyById(Long id) {
        return companyRepository.findById(id).get();
    }

    @Override
    public void deleteCompany(Long id) {
        companyRepository.deleteById(id);
    }
}
