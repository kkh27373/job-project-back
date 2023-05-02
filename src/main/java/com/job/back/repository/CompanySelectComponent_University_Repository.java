package com.job.back.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.job.back.entity.CompanySelectComponent_University_Entity;



@Repository
public interface CompanySelectComponent_University_Repository extends JpaRepository<CompanySelectComponent_University_Entity, String> {
    // ! 매개변수로 전화번호를 받고 그 전화번호에 해당하는 회사 인스턴스(여러가지 필드를 가진)를 반환한다 
    public CompanySelectComponent_University_Entity findByCompanyTelNumber(String companyTelNumber);
}
