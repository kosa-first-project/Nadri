package com.example.kosa_first_project.controller.login;


import mybatis.dao.login.FindIdMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class FindIdController {

    @Autowired
    private FindIdMapper findIdMapper;

    @GetMapping("/findID")
    public String findID() {
        return "user/findID";
    }

    @PostMapping("/findID")
    public String findId(@RequestParam String name,
                         @RequestParam String password,
                         @RequestParam String email,
                         Model model) {
        String userId = findIdMapper.resultId(name, email, password);

        if(!userId.equals("")) {
            model.addAttribute("userId",userId);
        } else {
            model.addAttribute("errorMessage", "아이디를 찾을 수 없습니다.");
        }
        return "user/findIdResult";
    }

}
