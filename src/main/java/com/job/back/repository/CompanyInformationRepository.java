package com.job.back.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.job.back.entity.CompanyInformationEntity;

@Repository
public interface CompanyInformationRepository extends JpaRepository<CompanyInformationEntity, String> {
   
    public CompanyInformationEntity findByCompanyTelNumber(String companyTelNumber );
}


