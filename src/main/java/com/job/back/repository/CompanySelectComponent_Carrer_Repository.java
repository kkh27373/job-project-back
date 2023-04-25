package com.job.back.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.job.back.entity.CompanySelectComponent_Carrer_Entity;

public interface CompanySelectComponent_Carrer_Repository extends JpaRepository<CompanySelectComponent_Carrer_Entity,String>{
    public CompanySelectComponent_Carrer_Repository findByCompanyTelNumber(String companyTelNumber);
    
}