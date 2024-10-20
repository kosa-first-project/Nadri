package com.example.kosa_first_project.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

//템플릿아래에 메인화면이 있을 때 사용할 클래스.
@Controller
public class HomeController {

    @GetMapping("/home") // /로 해놓으면 됨. 일단 home으로 변경해놓음.
    public String myPage(Model model) {
        return "martine/index";
    }
}
