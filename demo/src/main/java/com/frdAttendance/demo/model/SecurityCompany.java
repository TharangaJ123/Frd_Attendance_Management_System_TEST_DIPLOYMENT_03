package com.frdAttendance.demo.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.Random;
import java.util.UUID;


@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "security_company")
public class SecurityCompany {
    @Id
    @Column(name = "companyId")
    private String id;
    @Column(name = "companyName")
    private String companyName;
    @Column(name = "companyAddress")
    private String companyAddress;
    @Column(name = "companyContact")
    private String contactNumber;

    @PrePersist
    public void generateId() {
        //generating ID
        Random random = new Random();
        int number = random.nextInt(100) + 1; // Generates a number between 1 and 100
        String id = "SEC-COM-" + number;
        this.id = id;
    }

    @OneToMany(mappedBy = "company")
    @JsonBackReference
    private List<CompanyUsers> users;

    public String getId(){
        return id;
    }

    public String getCompanyName(){
        return companyName;
    }

    public String getCompanyAddress(){
        return companyAddress;
    }

    public String getContactNumber(){
        return contactNumber;
    }
}