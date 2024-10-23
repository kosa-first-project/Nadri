package com.example.kosa_first_project.controller.guide;

import com.example.kosa_first_project.domain.login.UserDTO;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

//guide 의 각 기능을 테스트 하기위한 호출 Controller //수정해서 사용
@Controller
public class CallMyPageController {

    @GetMapping("/guide/form")
    public String guideForm(HttpSession session, Model model) {
        /*
        UserDTO user = (UserDTO) session.getAttribute("user");

        if (user == null) {
            return "user/login";
        }
        */

        return "guide/guide_form"; // 가이드 폼을 보여주는 템플릿 이름 반환
    }

    @GetMapping("/mypage")
    public String myPage(HttpSession session, Model model) {
        /*
        UserDTO user = (UserDTO) session.getAttribute("user");

        if (user == null) {
            return "user/login";
        }
        */


        //return "redirect:/guide/mypage_guide_list.html"; // 리다이렉트 : 파일이 static 아래에 있어야함
        //return "guide/mypage_guide_list"; //templates 아래에 있으며, url이 바뀌지 않음.

        return "guide/mypage_guide_list";
    }

}