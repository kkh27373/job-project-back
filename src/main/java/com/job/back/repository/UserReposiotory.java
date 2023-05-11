package com.job.back.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.job.back.entity.UserEntity;

@Repository
public interface UserReposiotory extends JpaRepository<UserEntity,String> {
    
    public boolean existsByUserEmail(String userEmail);
    
    public boolean existsByUserTelNumber(String userTelNumber);

    public boolean existsByUserEmailOrUserTelNumber(String userEmail, String userTelNumber);

    public UserEntity findByUserEmail(String userEmail);

    public UserEntity findByUserTelNumber(String userTelNumber);
}
