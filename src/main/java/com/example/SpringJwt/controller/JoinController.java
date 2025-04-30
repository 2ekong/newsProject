package com.example.SpringJwt.controller;

import com.example.SpringJwt.dto.JoinDTO;
import com.example.SpringJwt.service.JoinService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@ResponseBody
public class JoinController {

    private final JoinService joinService;  //@Autowired 주입이 가능하지만 생성자 주입 권장

    public JoinController(JoinService joinService) {
        this.joinService = joinService;
    }
    @PostMapping("/join")
    public String joinProcess(JoinDTO joinDTO){    //회원가입
        joinService.joinProcess(joinDTO);
        return "success";
    }
}
