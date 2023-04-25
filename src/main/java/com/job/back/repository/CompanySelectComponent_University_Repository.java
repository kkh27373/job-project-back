package com.job.back.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.job.back.entity.CompanySelectComponent_University_Entity;



@Repository
public interface CompanySelectComponent_University_Repository extends JpaRepository<CompanySelectComponent_University_Entity, String> {
    public CompanySelectComponent_University_Repository findByCompanyTelNumber(String companyTelNumber);
}
