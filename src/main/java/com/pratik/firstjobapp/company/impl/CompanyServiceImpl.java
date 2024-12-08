package com.pratik.firstjobapp.company.impl;

import com.pratik.firstjobapp.company.Company;
import com.pratik.firstjobapp.company.CompanyRepository;
import com.pratik.firstjobapp.company.CompanyService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CompanyServiceImpl implements CompanyService {

    public final CompanyRepository companyRepository;

    public CompanyServiceImpl(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }

    @Override
    public List<Company> getAllCompanies() {
        return companyRepository.findAll();
    }

    @Override
    public boolean updateCompany(Company company, Long id) {
        Optional<Company> existingCompanyOptional = companyRepository.findById(id);

        if (existingCompanyOptional.isPresent()) {
            Company existingCompany = existingCompanyOptional.get();

            // Update fields
            existingCompany.setName(company.getName());
            existingCompany.setDescription(company.getDescription());
            existingCompany.setJobs(company.getJobs()); // This assumes jobs are provided in the input

            companyRepository.save(existingCompany);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public void createCompany(Company company) {
        companyRepository.save(company);
    }

    @Override
    public boolean deleteCompany(Long id) {
        if (companyRepository.existsById(id)) {
            companyRepository.deleteById(id);
            return true;
        } else {

            return false;
        }
    }
}
