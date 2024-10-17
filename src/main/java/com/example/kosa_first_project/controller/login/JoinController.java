package com.example.kosa_first_project.controller.login;

import com.example.kosa_first_project.domain.login.JoinUserDTO;
import mybatis.dao.login.JoinMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@Controller // Controller 어노테이션 추가
public class JoinController {
    @Autowired
    private JoinMapper joinDao;

   /* @Transactional
    @PostMapping("/join-controller")
    public String join(@RequestParam String id,
                       @RequestParam String password,
                       @RequestParam String password2,
                       @RequestParam String username,
                       @RequestParam String phone,
                       @RequestParam String gender,
                       @RequestParam String nickname,
                       @RequestParam String email,
                       @RequestParam String guide_activate) {

        if (password.equals(password2)){
            JoinUserDTO joinUserDTO = new JoinUserDTO();
            joinUserDTO.setId(id);
            joinUserDTO.setPassword(password);
            joinUserDTO.setUsername(username);
            joinUserDTO.setPhone(phone);
            joinUserDTO.setGender(gender);
            joinUserDTO.setNickname(nickname);
            joinUserDTO.setEmail(email);
            joinUserDTO.setGuide_activate(guide_activate);
            joinUserDTO.setCreate_date(LocalDateTime.now());
            joinDao.save(joinUserDTO);
            return "redirect:/joinComplete";
        }
        else{
            return "redirect:/joinFail";
        }
    }*/
   @Transactional
   @PostMapping("/join-controller")
   public String join(JoinUserDTO joinUserDTO) {
       if (joinUserDTO.getPassword().equals(joinUserDTO.getPasswordCheck())) {
           joinUserDTO.setCreate_date(LocalDateTime.now());
           joinDao.save(joinUserDTO);
           return "redirect:/joinComplete";
       } else {
           return "redirect:/joinFail";
       }
   }

    @GetMapping("/joinComplete")
    public String joinComplete() {
        return "complete";
    }
    @GetMapping("/joinFail")
    public String joinFail() {
        return "login";
    }

}
