package com.example.SpringJwt.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@Table(name = "user")  // 테이블 이름 명시
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;  // 회원 고유 번호 (PK)

    @Column(nullable = false, unique = true, length = 100)
    private String email;  // 로그인용 이메일 (UNIQUE)

    @Column(nullable = false, length = 255)
    private String password;  // 암호화된 비밀번호

    @Column(nullable = false, unique = true, length = 30)
    private String nickname;  // 닉네임 (UNIQUE)

    @Column(nullable = false, length = 10)
    private String role = "USER";  // 권한 (기본 USER)

    @Column(name = "last_login_ip", length = 45)
    private String lastLoginIp;  // 마지막 로그인 IP

    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt = LocalDateTime.now();  // 가입일
}
