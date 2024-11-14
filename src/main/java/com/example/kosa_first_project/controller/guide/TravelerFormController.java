package com.example.kosa_first_project.controller.guide;

import com.example.kosa_first_project.domain.guide.TravelerInfoDTO;
import com.example.kosa_first_project.service.guide.TravelerInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDateTime;

@Controller
@RequestMapping("/travelerForm")
public class TravelerFormController {


    @Autowired
    private TravelerInfoService travelerInfoService; // 서비스 주입

    @GetMapping
    public String showTravelerForm(@RequestParam("guide") String guideInfoId, Model model) {
        // Add the guideId to the model if needed
        model.addAttribute("guideInfoId", guideInfoId);
        return "guide/traveler_form"; // Return the view name
    }

    @PostMapping("/apply") // POST 요청을 처리하는 메서드
    public String applyForTravel(TravelerInfoDTO travelerInfoDTO,
                                 @RequestParam("guideInfoId") int guideInfoId) {
        travelerInfoDTO.setGuideInfoId(guideInfoId); // guideInfoId 설정
        travelerInfoDTO.setApplyTime(LocalDateTime.now()); // 신청 시간 설정
        travelerInfoDTO.setTravelerInfoState("신청중"); // 기본 상태 설정

        travelerInfoService.save(travelerInfoDTO); // 서비스 호출하여 저장

        return "redirect:/success"; // 성공 페이지로 리다이렉트
    }

}
