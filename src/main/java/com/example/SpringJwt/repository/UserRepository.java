package com.example.SpringJwt.repository;

import com.example.SpringJwt.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<UserEntity, Integer> {
    Boolean existsByEmail(String email);    //email이 존재하는지 확인
    Boolean existsByNickname(String nickname);

    Optional<UserEntity> findByEmail(String email);

}
