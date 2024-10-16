package com.example.kosa_first_project.controller.login;

import org.springframework.ui.Model; // org.springframework.ui.Model을 사용해야 함
import com.example.kosa_first_project.domain.login.JoinUserDTO;
import mybatis.dao.login.JoinMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller // Controller 어노테이션 추가
public class JoinController {

    @Autowired
    private JoinMapper joinDao;

    @PostMapping("/join-controller")
    public String join(@ModelAttribute JoinUserDTO joinUserDTO, Model model) {
        // 데이터베이스에 회원 가입 처리 로직 추가 필요
        joinDao.save(joinUserDTO); // 예시: 사용자 정보를 DB에 저장

        // 가입 완료 후 완료 페이지로 리다이렉트
        return "redirect:/joinComplete";
    }

    @GetMapping("/joinComplete")
    public String joinComplete() {
        return "complete"; // complete.html로 이동
    }
}

