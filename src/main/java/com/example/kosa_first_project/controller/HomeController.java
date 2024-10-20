package com.example.kosa_first_project.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    public String myPage(Model model) {
        return "martine/index"; //templates 아래에 있으며, url이 바뀌지 않음.
    }
}
