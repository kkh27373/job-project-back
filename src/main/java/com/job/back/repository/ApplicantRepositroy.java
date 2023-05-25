package com.job.back.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.job.back.entity.ApplicantEntity;
import com.job.back.entity.CompanyEntity;

@Repository
public interface ApplicantRepositroy extends JpaRepository<ApplicantEntity, String> {
    // public boolean findByApplicantUserEmail (String applicantUserEmail);
    public List<ApplicantEntity> findByApplicantCompanyTelNumber(String company_Tel_Number);
    public List<ApplicantEntity> findByApplicantUserEmail(String applicantUserEmail);
    public List<ApplicantEntity> findByApplicantCompanyTelNumberOrderByApplicantTotalScoreDesc(String company_Tel_Number);
    public ApplicantEntity findByApplicantCompanyTelNumberAndApplicantUserEmail(String company_tel_number,String applicantUserEmail);
    public ApplicantEntity findByApplicantUserEmailAndApplicantCompanyTelNumber(String applicantUserEmail,String company_Tel_Number);
    

}
