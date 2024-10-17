package com.example.kosa_first_project.controller.guide;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TestGuideController {

    //guide 의 각 기능을 테스트 하기위한 호출 Controller //수정해서 사용
    @GetMapping("/guide")
    public String myPage(Model model) {
        // 필요한 데이터 모델에 추가
        // model.addAttribute("message", "Hello, World!");
        return "guide/guide_form";
    }
}