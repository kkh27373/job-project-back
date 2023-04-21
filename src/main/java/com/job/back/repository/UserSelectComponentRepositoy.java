package com.job.back.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.job.back.entity.UserSelectComponentEntity;

public interface UserSelectComponentRepositoy extends JpaRepository<UserSelectComponentEntity,String> {
    public UserSelectComponentEntity findByUserUserEmail(String userUserEmail);
    
}
