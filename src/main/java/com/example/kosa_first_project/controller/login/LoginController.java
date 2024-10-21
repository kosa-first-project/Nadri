package com.example.kosa_first_project.controller.login;

import com.example.kosa_first_project.domain.login.UserDTO;
import jakarta.servlet.http.HttpSession;
import mybatis.dao.login.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class LoginController {
   @Autowired
   private UserMapper userMapper;

    private BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    @GetMapping("/login")
    public String loginForm() {
        return "user/login"; // templates의 login.html
    }

    @PostMapping("/login")
    public String login(@RequestParam String id,
                        @RequestParam String password,
                        HttpSession session,
                        RedirectAttributes redirectAttributes){
        //로그인할 유저에 담아줘
        UserDTO UserDTO = userMapper.login(id);
        System.out.println(UserDTO);

        if(UserDTO != null && passwordEncoder.matches(password, UserDTO.getPassword())){
            System.out.println(passwordEncoder.matches(password, UserDTO.getPassword()));
            System.out.println(2);
            session.setAttribute("User",UserDTO);
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
       return "user/complete"; //templates의 complete
    }

    @GetMapping("/login-fail")
    public String loginFail(){
        System.out.println(5);
        return "user/login"; //templates의 login
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
