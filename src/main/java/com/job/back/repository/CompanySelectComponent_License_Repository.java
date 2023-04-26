package com.job.back.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.job.back.entity.CompanySelectComponent_License_Entity;

public interface CompanySelectComponent_License_Repository extends JpaRepository<CompanySelectComponent_License_Entity,String>{
    public CompanySelectComponent_License_Repository findByCompanyTelNumber(String companyTelNumber);
}
