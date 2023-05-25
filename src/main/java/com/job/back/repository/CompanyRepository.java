package com.job.back.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.job.back.entity.ApplicantEntity;
import com.job.back.entity.CompanyEntity;
import com.job.back.entity.CompanySelectComponent_Carrer_Entity;
import com.job.back.entity.CompanySelectComponent_License_Entity;
import com.job.back.entity.CompanySelectComponent_University_Entity;
import com.job.back.entity.UserEntity;

@Repository
public interface CompanyRepository extends JpaRepository<CompanyEntity, Long> {
    public CompanyEntity findByCompanyTelNumber(String companyTelNumber);
    public List<CompanyEntity> findByCompanyNameContainsOrCompanyCategory(String companyName, String companyCategory);
    public List<CompanyEntity> findByCompanyEmail(String companyEmail);
    

    public boolean existsByCompanyEmail(String companyEmail);
    public boolean existsByCompanyTelNumber(String companyTelNumber);
    public List<CompanyEntity> findAll();

    

    
}


