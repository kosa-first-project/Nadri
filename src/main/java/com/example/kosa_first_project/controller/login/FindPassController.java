package com.example.kosa_first_project.controller.login;

import jakarta.servlet.http.HttpSession;
import mybatis.dao.login.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class FindPassController {

    @Autowired
    private UserMapper userMapper;
    
    //비밀번호 인코딩 클래스
    private BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
    
    //비밀번호 찾기 페이지
    @GetMapping("/findPass")
    public String findPassInfo() {
        return "user/findPass";
    }


    @PostMapping("/findPass")
    public String findPassInfo(@RequestParam String username,
                               @RequestParam String email,
                               @RequestParam String id,
                               HttpSession session) {
        if(userMapper.findPassword(username, email, id) == 1){
            session.setAttribute("userId", id);
           return "redirect:/goUpdatePass";
        }
        else {
           return "redirect:/notGoUpdatePass";
        }
    }

    @GetMapping("/goUpdatePass")
    public String goPassUpdate() {
        System.out.println("/goUpdatePass");
        return "user/findPassUpdate";
    }

    @GetMapping("/notGoUpdatePass")
    public String findPassNotUpdate() {
        System.out.println("/notGoUpdatePass");
        return "user/complete";
    }

   @PostMapping("/updatePassword")
    public String updatePassword(@RequestParam String password,
                                 @RequestParam String passwordCheck,
                                 HttpSession session) {

        String id = (String) session.getAttribute("userId");

        if(password.equals(passwordCheck)){
            System.out.println("updatePassword");
            password = passwordEncoder.encode(password);
            userMapper.updatePassword(password, id);
            return "redirect:/checkPassword";
        }
        else {
            System.out.println("notUpdatePassword");
            return "redirect:/notCheckPassword";
        }
    }

    @GetMapping("/checkPassword")
    public String checkPassword() {
        System.out.println("checkPassword");
        return "user/complete";
    }
    @GetMapping("/notCheckPassword")
    public String notCheckPassword() {
        System.out.println("notCheckPassword");
        return "user/complete";
    }
}
