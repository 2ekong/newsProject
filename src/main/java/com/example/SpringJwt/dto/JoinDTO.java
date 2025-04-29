package com.example.SpringJwt.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class JoinDTO {  //회원가입 데이터들을 받을 곳

    private String email;       // 사용자 입력
    private String password;    // 사용자 입력 (서버에서 BCrypt로 암호화)
    private String nickname;    // 사용자 입력

}
