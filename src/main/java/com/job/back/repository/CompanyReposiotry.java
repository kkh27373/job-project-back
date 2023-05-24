package com.job.back.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.job.back.entity.ApplicantEntity;
import com.job.back.entity.CompanyEntity;
import com.job.back.entity.UserEntity;

@Repository
public interface CompanyReposiotry extends JpaRepository<CompanyEntity, String> {
    public CompanyEntity findByCompanyTelNumber(String companyTelNumber);
    public CompanyEntity findByCompanyEmail(String companyEmail);

    public boolean existsByCompanyEmail(String companyEmail);
    public boolean existsByCompanyTelNumber(String companyTelNumber);
    public List<CompanyEntity> findAll();
    
    public List<UserEntity> findAllByCompanyEmail(String companyEmail);
}


