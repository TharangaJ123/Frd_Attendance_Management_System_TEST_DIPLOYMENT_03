package com.frdAttendance.demo.dto;

import com.frdAttendance.demo.model.CompanyUsers;

import java.util.List;

public class SecurityCompanyDTO {
    private String id;
    private String companyName;
    private String companyAddress;
    private String contactNumber;
    private List<CompanyUsers> users; // Optional: Include users if needed

    // Getters and Setters
}

