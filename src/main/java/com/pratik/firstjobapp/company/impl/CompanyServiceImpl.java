package com.pratik.firstjobapp.company.impl;

import com.pratik.firstjobapp.company.Company;
import com.pratik.firstjobapp.company.CompanyRepository;
import com.pratik.firstjobapp.company.CompanyService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompanyServiceImpl implements CompanyService {

    private CompanyRepository companyRepository;

    public CompanyServiceImpl(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }

    @Override
    public List<Company> getAllCompanies() {
        return companyRepository.findAll();
    }
}
