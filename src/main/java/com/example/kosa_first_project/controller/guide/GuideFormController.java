package com.example.kosa_first_project.controller.guide;

import com.example.kosa_first_project.domain.guide.GuideInfoDTO;
import com.example.kosa_first_project.service.guide.GuideFormService;
import com.example.kosa_first_project.service.guide.GuideListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@RestController
@RequestMapping("/guideForm")
public class GuideFormController {

    @Autowired
    private GuideFormService guideFormService;


    @PostMapping
    public ResponseEntity<Void> createGuide(@ModelAttribute GuideInfoDTO guideInfoDTO) {

        // 나중에 세션에서 UserID 가져와야 함.
        guideInfoDTO.setUserId("user1");
        guideInfoDTO.setGuideInfoState("activate");

        guideFormService.saveGuideInfo(guideInfoDTO);
        return ResponseEntity.ok().build(); // 성공적으로 처리됨


/*

        if (guideInfoDTO.getGuideInfoId() != null) {
            // 기존 가이드 업데이트
            guideFormService.updateGuideInfo(guideInfoDTO);
            redirectAttributes.addFlashAttribute("message", "가이드 정보가 수정되었습니다.");
        } else {
            // 새 가이드 저장
            guideFormService.saveGuideInfo(guideInfoDTO);
            redirectAttributes.addFlashAttribute("message", "가이드 정보가 저장되었습니다.");
        }
*/
        //페이지 전환할지 알림을 할지 고민
        //return "redirect:/guide/mypage_guide_list.html"; // 리다이렉트 : 파일이 static 아래에 있어야함
        //return "guide/mypage_guide_list"; //templates 아래에 있으며, url이 바뀌지 않음.
    }

    @PutMapping("/{guideInfoId}")
    public ResponseEntity<Void> updateGuide(@PathVariable int guideInfoId, @ModelAttribute GuideInfoDTO guideInfoDTO) {
        guideInfoDTO.setGuideInfoId(guideInfoId); // ID 설정
        guideFormService.saveGuideInfo(guideInfoDTO);
        return ResponseEntity.ok().build(); // 성공적으로 처리됨
    }

    @GetMapping("/{guideInfoId}")
    public ResponseEntity<GuideInfoDTO> getGuide(@PathVariable int guideInfoId) {
        GuideInfoDTO guideInfo = guideFormService.getGuideInfo(guideInfoId);
        return ResponseEntity.ok(guideInfo);
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