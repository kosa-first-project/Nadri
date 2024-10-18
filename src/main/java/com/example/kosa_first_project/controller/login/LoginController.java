package com.example.kosa_first_project.controller.login;

import com.example.kosa_first_project.domain.login.LoginUserDTO;
import jakarta.servlet.http.HttpSession;
import mybatis.dao.login.LoginMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class LoginController {
   @Autowired
   private LoginMapper loginMapper;

    @GetMapping("/login")
    public String loginForm() {
        return "user/login"; // templates의 login.html
    }

    @PostMapping("/login")
    public String login(@RequestParam("loginID") String id,
                        @RequestParam("loginPass") String pass,
                        HttpSession session,
                        RedirectAttributes redirectAttributes){
        LoginUserDTO loginUserDTO = loginMapper.login(id);
        System.out.println(1);
        if(loginUserDTO != null && loginUserDTO.getPassword().equals(pass)){
            System.out.println(2);
            session.setAttribute("loginUser",loginUserDTO);
            return "redirect:/login-success";
        }
        else{
            System.out.println(3);
            redirectAttributes.addFlashAttribute("failMessage", "아이디 또는 비밀번호가 잘못되었습니다.");
            return "redirect:/login-fail";
        }
    }

    @GetMapping("/login-success")
    public String loginSuccess(){
        System.out.println(4);
       return "user/complete"; //templates의 complete.html
    }

    @GetMapping("/login-fail")
    public String loginFail(){
        System.out.println(5);
        return "user/login"; //templates의 login.html
    }
    @GetMapping("/user/findID")
    public String findIDForm() {
        System.out.println(6);
        return "user/findID"; // templates의 findID.html
    }

    @GetMapping("/user/findPass")
    public String findPassForm() {
        System.out.println(7);
        return "user/findPass"; // templates의 findPass.html
    }

    @GetMapping("/user/join")
    public String joinForm() {
        System.out.println(8);
        return "user/join"; // templates의 join.html
    }
}
