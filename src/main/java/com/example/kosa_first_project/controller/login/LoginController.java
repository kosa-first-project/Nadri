package com.example.kosa_first_project.controller.login;

import com.example.kosa_first_project.domain.login.LoginUserDTO;
import jakarta.servlet.http.HttpSession;
import mybatis.dao.login.LoginMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class LoginController {
   @Autowired
   private LoginMapper loginMapper;

   @GetMapping("/login-fail")
   public String loginFail(Model model) {
       return "login";
   }

    @PostMapping("/login")
    public String login(@RequestParam("loginID") String id,
                        @RequestParam("loginPass") String pass,
                        HttpSession session,
                        RedirectAttributes redirectAttributes){
        LoginUserDTO loginUserDTO = loginMapper.login(id, pass);

        if(loginUserDTO!=null){
            session.setAttribute("loginUser",loginUserDTO);
            return "redirect:/login-success";
        }
        else{
            redirectAttributes.addFlashAttribute("failMessage", "아이디 또는 비밀번호가 잘못되었습니다.");
            return "redirect:/login-fail";
        }
    }

    @GetMapping("login-success")
    public String loginSuccess(){
       return "complete";
    }
}
