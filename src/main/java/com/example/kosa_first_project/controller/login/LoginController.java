package com.example.kosa_first_project.controller.login;

import org.springframework.ui.Model;
import com.example.kosa_first_project.domain.login.UserDTO;
import jakarta.servlet.http.HttpSession;
import mybatis.dao.login.LoginMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;



@Controller
public class LoginController {
    @Autowired
    private LoginMapper dao;


    @PostMapping( "/login-controller")
    public String login(@RequestParam("loginID") String id,
                        @RequestParam("loginPass") String pass,
                        HttpSession session,
                        Model model) {

        UserDTO dto = dao.login(id, pass);
        // 로그인 시도
        if (dto == null) {
            // 로그인 실패
            System.out.println("로그인 실패: 아이디 또는 비밀번호가 잘못되었습니다.");
            model.addAttribute("errorMessage", "아이디 또는 비밀번호가 잘못되었습니다.");
            return "redirect:/login"; // 로그인 페이지로 다시 이동
        } else {
            // 로그인 성공
            System.out.println("로그인 성공: " + dto.getId());
            session.setAttribute("user", dto);
            return "redirect:/complete";
        }
    }
    @GetMapping("/login")
    public String shoFailPage() {
        return "login"; // complete.html 템플릿 반환
    }

    @GetMapping("/complete")
    public String showCompletePage() {
        return "complete"; // complete.html 템플릿 반환
    }
}