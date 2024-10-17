package com.example.kosa_first_project.controller.guide;

import com.example.kosa_first_project.domain.guide.GuideInfoDTO;
import com.example.kosa_first_project.domain.guide.GuideUnavailableTimeDTO;
import com.example.kosa_first_project.service.guide.GuideFormService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
public class GuideFormController {

    @Autowired
    private GuideFormService guideFormService;


    //GET으로 잘못들어왔는지 TEST
    @GetMapping("/guideForm")
    public String showGuideForm() {
        return "guide_form"; // 뷰의 이름 반환 (HTML 페이지)
    }
    @PostMapping("/guideForm")
    public ResponseEntity<String> saveGuideForm(@ModelAttribute GuideInfoDTO guideInfoDTO) {
        guideFormService.saveGuideInfo(guideInfoDTO);
        return ResponseEntity.ok("Guide info saved successfully.");
    }
}

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
