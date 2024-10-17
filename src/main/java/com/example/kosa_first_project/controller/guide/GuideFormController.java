package com.example.kosa_first_project.controller.guide;

import com.example.kosa_first_project.domain.guide.GuideInfoDTO;
import com.example.kosa_first_project.service.guide.GuideFormService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class GuideFormController {

    @Autowired
    private GuideFormService guideFormService;

    @GetMapping("/guideForm")
    public String showGuideForm() {
        return "guide_form"; // 뷰의 이름 반환 (HTML 페이지)
    }

    @PostMapping("/guideForm")
    public String saveGuideForm(@ModelAttribute GuideInfoDTO guideInfoDTO) {

        // 나중에 세션에서 UserID 가져와야 함.
        guideInfoDTO.setUserId("user1");
        guideInfoDTO.setGuideInfoState("activate");

        guideFormService.saveGuideInfo(guideInfoDTO);

        return "guide/guide_card"; // 페이지 이동
    }
}

        /*
        //나중에 세션에서 UserID 가져와야 함.
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String userId = auth.getName(); // 사용자 ID (또는 다른 정보를 가져올 수 있음)
        guideInfoDTO.setUserId(userId);
        */



    /*
    @PostMapping("/guides")
    public String addGuide(@RequestBody GuideInfoDTO guideinfoDTO) {
        guideFromService.saveGuideInfo(guideinfoDTO);
        return "가이드 정보가 저장되었습니다.";
    }*/


    /*
    @PostMapping
    public ResponseEntity<String> addGuide(@RequestBody GuideInfoDTO guideinfoDTO) {
        try {
            guideFromService.saveGuideInfo(guideinfoDTO);
            return ResponseEntity.ok("Guide saved successfully");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error saving guide");
        }
    }*/