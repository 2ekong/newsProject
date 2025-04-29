package com.example.SpringJwt.repository;

import com.example.SpringJwt.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity, Integer> {
    Boolean existsByEmail(String email);    //email이 존재하는지 확인
}
