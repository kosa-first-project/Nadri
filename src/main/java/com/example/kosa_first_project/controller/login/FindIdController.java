package com.example.kosa_first_project.controller.login;

import mybatis.dao.login.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class FindIdController {

    @Autowired
    private UserMapper userMapper;


    @GetMapping("/findID")
    public String findID() {
        return "user/findID";
    }
    //아이디 찾기 페이지 접속하는 url

    @PostMapping("/findID")
    public String findId(@RequestParam String username,
                         @RequestParam String email,
                         Model model) {
        //회원 이름과 이메일이 있으면 찾은 ID, 없으면 "" 반환
        String userId = userMapper.resultId(username, email);

        if(userId != null && !userId.equals("")) {
            //userID가 null과 빈 값이 아니면 찾은 ID 보여주기
            model.addAttribute("userId",userId);
            return "user/findIdResult";
        } else {
            return "redirect:fail";
        }
    }

    @GetMapping("fail")
    public String fail(Model model) {
        //userID가 null혹은 빈 값이면 에러메시지 출력
        model.addAttribute("failMessage", "입력한 정보와 일치하는 아이디를 찾을 수 없습니다.");
        return "user/findID";
    }

}
