package com.example.SpringJwt.service;

import com.example.SpringJwt.dto.JoinDTO;
import com.example.SpringJwt.entity.UserEntity;
import com.example.SpringJwt.repository.UserRepository;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class JoinService {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    public JoinService(UserRepository userRepository, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.userRepository = userRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }
    public void joinProcess(JoinDTO joinDTO) {
        String email = joinDTO.getEmail();
        String password = joinDTO.getPassword();
        String nickname = joinDTO.getNickname();
        
        Boolean isExistEmail = userRepository.existsByEmail(email);  //존재하는지 true, false로 받고
        if (isExistEmail) {
            throw new IllegalStateException("이미 사용 중인 이메일입니다.");
        }

        Boolean isExistNickname = userRepository.existsByNickname(nickname);
        if (isExistNickname) {
            throw new IllegalStateException("이미 사용 중인 닉네임입니다.");
        }


        UserEntity data = new UserEntity();

        data.setEmail(email);
        data.setPassword(bCryptPasswordEncoder.encode(password)); //  암호화 필수!
        data.setNickname(nickname);
        data.setRole("USER");


        userRepository.save(data);

    }
}
