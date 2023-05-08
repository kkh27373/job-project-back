package com.job.back.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.job.back.entity.ApplicantEntity;

@Repository
public interface ApplicantRepositroy extends JpaRepository<ApplicantEntity, String> {
    // public boolean findByApplicantUserEmail (String applicantUserEmail);
    public List<ApplicantEntity> findByApplicantCompanyTelNumber(String company_Tel_Number);
    public ApplicantEntity findByApplicantUserEmail(String applicantUserEmail);
    public List<ApplicantEntity> findByApplicantCompanyTelNumberOrderByApplicantTotalScoreDesc(String company_Tel_Number);
    public ApplicantEntity findByApplicantCompanyTelNumberAndApplicantUserEmail(String company_tel_number,String applicantUserEmail);
}
