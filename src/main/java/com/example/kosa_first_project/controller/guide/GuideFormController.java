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

@Controller
@RequestMapping("/guideForm")
public class GuideFormController {

    @Autowired
    private GuideFormService guideFormService;
/*
    @GetMapping
    public String showGuideForm(@RequestParam(required = false) Long guideInfoId, Model model) {
        if (guideInfoId != null) {
            // guideInfoId가 주어진 경우, 해당 가이드 정보를 조회
            GuideInfoDTO guideInfo = guideFormService.getGuideInfoById(guideInfoId); // 서비스에서 가이드 정보 조회
            model.addAttribute("guideInfo", guideInfo); // 모델에 가이드 정보 추가
        } else {
            model.addAttribute("guideInfo", new GuideInfoDTO()); // 새 가이드 등록 시 빈 객체 추가
        }
        return "guide/guide_form"; // templates/guide/guide_form.html을 반환
    }*/
    @GetMapping
    public String showGuideForm(Model model) {
        // 새로운 빈 GuideInfoDTO 객체 생성
        GuideInfoDTO guideInfo = new GuideInfoDTO();

        model.addAttribute("guideInfo", guideInfo);

        return "guide/guide_form"; // templates/guide/guide_form.html을 반환
    }

    @PostMapping
    public String createGuide(@ModelAttribute GuideInfoDTO guideInfoDTO) {
        // 나중에 세션에서 UserID 가져와야 함.
        guideInfoDTO.setUserId("user1");
        guideInfoDTO.setGuideInfoState("activate");

        guideFormService.saveGuideInfo(guideInfoDTO);

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
        return "guide/mypage_guide_list"; //templates 아래에 있으며, url이 바뀌지 않음.
    }

    /*
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
    }*/

    @PutMapping("/{guideInfoId}")
    public String updateGuide(@PathVariable int guideInfoId, @ModelAttribute GuideInfoDTO guideInfoDTO) {
        guideInfoDTO.setGuideInfoId(guideInfoId); // ID 설정
        guideFormService.updateGuideInfo(guideInfoDTO);
        return "guide/mypage_guide_list"; // 리다이렉트할 URL
    }



    @PutMapping("/{guideInfoId}/state")
    public String updateGuideInfoState(@PathVariable int guideInfoId, @RequestBody GuideInfoDTO guideInfoDTO) {//@ModelAttribute GuideInfoDTO guideInfoDTO 아님
        guideInfoDTO.setGuideInfoId(guideInfoId); // ID 설정
        guideFormService.updateGuideInfoState(guideInfoDTO);
        return "guide/mypage_guide_list"; // 리다이렉트할 URL
    }




    @GetMapping("/{guideInfoId}")
    public String getGuide(@PathVariable int guideInfoId, Model model) {
        try {
            GuideInfoDTO guideInfo = guideFormService.getGuideInfo(guideInfoId);
            model.addAttribute("guideInfo", guideInfo);
            return "guide/guide_form"; // 수정된 경로
        } catch (Exception e) {
            // 에러 로깅
            System.err.println("Error fetching guide info: " + e.getMessage());
            return "error"; // 오류 처리 페이지로 리다이렉트
        }



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