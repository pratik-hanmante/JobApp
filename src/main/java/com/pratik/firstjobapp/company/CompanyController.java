package com.pratik.firstjobapp.company;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/companies")
public class CompanyController {

    private final CompanyService companyService;

    public CompanyController(CompanyService companyService) {
        this.companyService = companyService;
    }

    /**
     *
     * @return List of all companies with an HTTP status of 200 (OK).
     */
    @GetMapping
    public ResponseEntity<List<Company>> getAllCompanies() {
        List<Company> companies = companyService.getAllCompanies();
        return ResponseEntity.ok(companies);
    }

    /**
     
     *
     * @param id      ID of the company to update.
     * @param company Updated company details.
     * @return Response indicating success or failure of the update.
     */
    @PutMapping("/{id}")
    public ResponseEntity<String> updateCompany(@PathVariable Long id, @RequestBody Company company) {
        boolean isUpdated = companyService.updateCompany(company, id);

        if (isUpdated) {
            return ResponseEntity.ok("Company updated successfully.");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Company with ID " + id + " not found.");
        }
    }

    /**
     * Add a new company.
     *
     * @param company The company to add.
     * @return Response indicating the success of the addition.
     */
    @PostMapping
    public ResponseEntity<String> addCompany(@RequestBody Company company) {
        companyService.createCompany(company);
        return ResponseEntity.status(HttpStatus.CREATED).body("Company added successfully.");
    }

    @DeleteMapping("/{id}")
    public  ResponseEntity<String>deleteCompany(@PathVariable Long id) {
        boolean isDeleted = companyService.deleteCompany(id);
        if (isDeleted) {
            return new ResponseEntity<>("Company delete successfully", HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>("Company doesnt exit", HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/{id}")
public ResponseEntity<Company>  getCompany(@PathVariable Long id) {
        Company company = companyService.getCompanyById(id);
        if (company != null) {
            return new ResponseEntity<Company>(company, HttpStatus.OK);
        }
        else {
            return  new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
