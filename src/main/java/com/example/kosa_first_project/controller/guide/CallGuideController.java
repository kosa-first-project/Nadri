package com.example.kosa_first_project.controller.guide;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

//templates 에 있는 html을 부르기 위한 Controller
@Controller
public class CallGuideController {

    @GetMapping("/guide")
    public String guideCard(Model model) {

        return "guide/guide_card";
    }


    @GetMapping("/guide-mini")
    public String loadGuideCard() {
        return "guide/guide_mini"; // guide_card.html의 내용을 반환
    }
/*
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
    }*/
}
