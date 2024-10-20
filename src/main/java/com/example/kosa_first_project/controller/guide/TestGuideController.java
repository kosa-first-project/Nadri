package com.example.kosa_first_project.controller.guide;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

//guide 의 각 기능을 테스트 하기위한 호출 Controller //수정해서 사용
@Controller
public class TestGuideController {
/*
    @GetMapping("/guide")
    public String guideCard(Model model) {

        return "guide/guide_card";
    }*/

    @GetMapping("/guide/form")
    public String guideForm(Model model) {
        return "guide/guide_form";
    }

    @GetMapping("/mypage")
    public String myPage(Model model) {
        // 필요한 데이터 모델에 추가
        // model.addAttribute("message", "Hello, World!");

        //return "redirect:/guide/mypage_guide_list.html"; // 리다이렉트 : 파일이 static 아래에 있어야함
        //return "guide/mypage_guide_list"; //templates 아래에 있으며, url이 바뀌지 않음.

        return "guide/mypage_guide_list";
    }

}