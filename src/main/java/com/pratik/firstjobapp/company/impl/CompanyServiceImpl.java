package com.pratik.firstjobapp.company.impl;

import com.pratik.firstjobapp.company.Company;
import com.pratik.firstjobapp.company.CompanyRepository;
import com.pratik.firstjobapp.company.CompanyService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CompanyServiceImpl implements CompanyService {

    private final CompanyRepository companyRepository;

    public CompanyServiceImpl(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }

    @Override
    public List<Company> getAllCompanies() {
        return companyRepository.findAll();
    }

    @Override
    public boolean updateCompany(Company company, Long id) {
        Optional<Company> companyOptional = companyRepository.findById(id);
        if (companyOptional.isPresent()) {
            Company companyToUpdate = companyOptional.get();

            if (company.getDescription() != null) {
                companyToUpdate.setDescription(company.getDescription());
            }
            if (company.getName() != null) {
                companyToUpdate.setName(company.getName());
            }
            if (company.getJobs() != null) {
                companyToUpdate.setJobs(company.getJobs());
            }

            companyRepository.save(companyToUpdate);
            return true;
        } else {
            return false;
        }
    }
}
