package com.job.back.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.job.back.entity.UserSelectComponentEntity;

@Repository
public interface UserSelectComponentRepositoy extends JpaRepository<UserSelectComponentEntity,String> {
    public UserSelectComponentEntity findByUserUserEmail(String userUserEmail);
    
}
