package com.example.kosa_first_project.controller.guide;

import com.example.kosa_first_project.domain.guide.GuideInfoDTO;
import com.example.kosa_first_project.domain.guide.GuideUnavailableTimeDTO;
import com.example.kosa_first_project.service.guide.GuideFormService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@RestController
public class GuideFormController {

    @Autowired
    private GuideFormService guideFormService;


    @PostMapping("/guideForm")
    public ResponseEntity<String> saveGuide(@RequestBody GuideInfoDTO guideInfoDTO, @RequestBody GuideUnavailableTimeDTO guideUnavailableTimeDTO) {
        guideFormService.saveGuideInfo(guideInfoDTO);
        return ResponseEntity.ok("Guide info saved successfully."); // JSON 응답
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
