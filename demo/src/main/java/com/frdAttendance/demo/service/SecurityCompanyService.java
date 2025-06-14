package com.frdAttendance.demo.service;

import com.frdAttendance.demo.model.CompanyUsers;
import com.frdAttendance.demo.model.SecurityCompany;
import com.frdAttendance.demo.repository.SecurityCompanyRepository;
import com.frdAttendance.demo.repository.SecurityStaffRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class SecurityCompanyService {
    @Autowired
    private SecurityCompanyRepository repository;
    @Autowired
    private SecurityStaffRepository securityStaffRepository;
    @Autowired
    private SecurityCompanyRepository securityCompanyRepository;

    public ResponseEntity<SecurityCompany> onboardCompany(SecurityCompany securityCompany) {
        securityCompany = repository.save(securityCompany);

        if(securityCompany.getId()==null){
            throw new RuntimeException("Security company id is null");
        }else{
            return ResponseEntity.ok(securityCompany);
        }
    }

    public List<SecurityCompany> getAllCompanies() {
        return repository.findAll();
    }

    public long getSecurityCompanyCount() {
        return repository.count();
    }

    public Optional<SecurityCompany> getCompanyById(String companyId) {
        return securityCompanyRepository.findById(companyId);
    }
}
