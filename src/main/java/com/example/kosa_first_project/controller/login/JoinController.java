package com.example.kosa_first_project.controller.login;

import com.example.kosa_first_project.domain.login.JoinUserDTO;
import mybatis.dao.login.JoinMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller // Controller 어노테이션 추가
public class JoinController {

    @Autowired
    private JoinMapper joinMapper;

    @GetMapping("/join")
    public String joinForm(){
        return "user/join"; // templates의 join.html
    }

    @PostMapping("/join")
    public String join(JoinUserDTO joinUserDTO) {
        // 데이터베이스에 회원 가입 처리 로직 추가 필요
        joinMapper.save(joinUserDTO); // 예시: 사용자 정보를 DB에 저장

        // 가입 완료 후 완료 페이지로 리다이렉트
        return "redirect:/joinComplete";
    }

    @GetMapping("/joinComplete")
    public String joinComplete() {
        return "/user/complete"; // complete.html로 이동
    }
}

