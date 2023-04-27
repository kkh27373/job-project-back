package com.job.back.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.job.back.entity.CompanySelectComponent_License_Entity;

@Repository
public interface CompanySelectComponent_License_Repository extends JpaRepository<CompanySelectComponent_License_Entity,String>{
    public CompanySelectComponent_License_Repository findByCompanyTelNumber(String companyTelNumber);
}
