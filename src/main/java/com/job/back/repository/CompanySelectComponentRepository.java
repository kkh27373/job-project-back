package com.job.back.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.job.back.entity.CompanySelectComponentEntity;

@Repository
public interface CompanySelectComponentRepository extends JpaRepository<CompanySelectComponentEntity, String> {
    public CompanySelectComponentEntity findByCompanyTelNumber(String companyTelNumber);
}
