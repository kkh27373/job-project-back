package com.job.back.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.job.back.entity.UserWishListEntity;

@Repository
public interface UserWishListRepository extends JpaRepository<UserWishListEntity,String>{
    
}
