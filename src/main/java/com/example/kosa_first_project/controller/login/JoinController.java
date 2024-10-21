package com.example.kosa_first_project.controller.login;

import com.example.kosa_first_project.domain.login.UserDTO;
import mybatis.dao.login.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller // Controller 어노테이션 추가
public class JoinController {

    @Autowired
    private UserMapper userMapper;

    private BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    @GetMapping("/join")
    public String joinForm(){
        return "user/join"; // templates의 join.html
    }

    @PostMapping("/join")
    public String join(UserDTO userDTO) {
        // DTO에 담긴 password만 추출하여 비밀번호 해시화, 그 후 해시화한 비밀번호를 DTO에 설정
        
        //비밀번호와 비밀번호 확인과 일치해야 회원가입 정보가 이동.
        if(userDTO.getPassword().equals(userDTO.getPasswordCheck())) {
           
            //평문으로 받은 비밀번호를 객체에서 꺼내고 해시화한 후, 해시화한 비밀번호를 객체에 넣음 
            String password = passwordEncoder.encode(userDTO.getPassword());
            userDTO.setPassword(password);
            
            // 회원 정보를 DB에 저장
            userMapper.save(userDTO);
            
            // 가입 완료 후 완료 페이지로 리다이렉트
            return "redirect:/joinComplete";
        }
        else {

            return "user/join";
        }
    }

    @GetMapping("/joinComplete")
    public String joinComplete() {
        return "/user/complete"; // complete로 이동
    }

    @RequestMapping (value = "/checkId", produces = "application/json; charset=utf-8")
    @ResponseBody
    public int id(String id) {
        return userMapper.findUserCount(id);
    }
}

