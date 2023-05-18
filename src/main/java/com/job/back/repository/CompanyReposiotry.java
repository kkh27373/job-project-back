package com.job.back.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.job.back.entity.CompanyEntity;

@Repository
public interface CompanyReposiotry extends JpaRepository<CompanyEntity, String> {
    public CompanyEntity findByCompanyTelNumber(String companyTelNumber);
    public CompanyEntity findByCompanyEmail(String companyEmail);
    public List<CompanyEntity> findByCompanyNameContainsOrCompanyCategory(String companyName, String companyCategory);

    public boolean existsByCompanyEmail(String companyEmail);
    public boolean existsByCompanyTelNumber(String companyTelNumber);
    public List<CompanyEntity> findAll();
    
}


