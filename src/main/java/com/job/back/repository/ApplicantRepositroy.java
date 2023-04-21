package com.job.back.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.job.back.entity.ApplicantEntity;

@Repository
public interface ApplicantRepositroy extends JpaRepository<ApplicantEntity, String> {
    public boolean findByApplicantUserEmail (String applicantUserEmail);
}
