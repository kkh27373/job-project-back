package com.job.back.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.job.back.entity.CompanySelectComponent_Carrer_Entity;

@Repository
public interface CompanySelectComponent_Carrer_Repository extends JpaRepository<CompanySelectComponent_Carrer_Entity,String>{
    public CompanySelectComponent_Carrer_Entity findByCompanyTelNumber(String companyTelNumber);
    
}