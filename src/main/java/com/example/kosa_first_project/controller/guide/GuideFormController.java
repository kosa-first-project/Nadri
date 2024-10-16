package com.example.kosa_first_project.controller.guide;

import com.example.kosa_first_project.domain.guide.GuideInfoDTO;
import com.example.kosa_first_project.service.guide.GuideFormService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/guideForm")
public class GuideFormController {

    @Autowired
    private GuideFormService guideFromService;

    @PostMapping("/add")
    public String addGuide(@RequestBody GuideInfoDTO guideDTO) {
        guideFromService.saveGuideInfo(guideDTO);
        return "가이드 정보가 저장되었습니다.";
    }
}
