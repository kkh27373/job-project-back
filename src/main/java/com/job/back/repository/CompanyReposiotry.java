package com.job.back.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.job.back.entity.CompanyEntity;

@Repository
public interface CompanyReposiotry extends JpaRepository<CompanyEntity, String> {
    public CompanyEntity findByCompanyTelNumber(String companyTelNumber);
    public CompanyEntity findByCompanyEmail(String companyEmail);

    public boolean existsByCompanyEmail(String companyEmail);
    public boolean existsByCompanyTelNumber(String companyTelNumber);
    
}


