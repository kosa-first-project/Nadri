package com.example.kosa_first_project.controller.guide;

import com.example.kosa_first_project.domain.guide.GuideInfoDTO;
import com.example.kosa_first_project.domain.login.UserDTO;
import com.example.kosa_first_project.service.guide.GuideListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/guides")
public class GuideListController {

    @Autowired
    private GuideListService guideListService;


    @PostMapping
    public ResponseEntity<Void> addGuide(@RequestBody GuideInfoDTO guideInfo) {
        guideListService.addGuide(guideInfo);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping//마이페이지 전체 조회 할때
    public ResponseEntity<List<GuideInfoDTO>> getAllGuides() {
        List<GuideInfoDTO> guides = guideListService.getAllGuides();
        return new ResponseEntity<>(guides, HttpStatus.OK);
    }
    @GetMapping("/my") // 마이페이지에서 내 활동만 검색 할 때 사용
    public ResponseEntity<List<GuideInfoDTO>> getMyGuides(@SessionAttribute("user") UserDTO user) {
        if (user == null) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(new ArrayList<>()); // 빈 리스트를 반환
        }

        String userId = user.getId();
        List<GuideInfoDTO> myGuides = guideListService.getMyGuides(userId);
        return new ResponseEntity<>(myGuides, HttpStatus.OK);
    }
/*
    @GetMapping("/my") // 마이페이지에서 내 활동만 검색 할 때 사용
    public String getMyGuides(Model model, @SessionAttribute("userId") String userId) {
        List<GuideInfoDTO> myGuides = guideListService.getMyGuides(userId);
        model.addAttribute("myGuides", myGuides);
        return "guide/mypage_guide_list"; // 가이드 리스트를 보여줄 템플릿 이름
    }*/

    @GetMapping("/list") //카드형식에서 사용
    public String getAllGuides(Model model) {
        List<GuideInfoDTO> guides = guideListService.getAllGuides();
        model.addAttribute("guides", guides);
        return "guide/guide_list"; // HTML 템플릿 파일 경로
    }
/*
    @GetMapping("/search")
    public ResponseEntity<List<GuideInfoDTO>> searchGuides(
            @RequestParam(required = false) String search,
            @RequestParam(required = false) String city) {
        List<GuideInfoDTO> guides = guideListService.searchGuides(search, city);
        return new ResponseEntity<>(guides, HttpStatus.OK);
    }*/


    @GetMapping("/search")
    public ResponseEntity<List<GuideInfoDTO>> searchGuides(
            @RequestParam(required = false) String search,
            @RequestParam(required = false) String city,
            @RequestParam(required = false) String status) {
        List<GuideInfoDTO> guides = guideListService.searchGuides(search, city, status);
        return new ResponseEntity<>(guides, HttpStatus.OK);
    }

    @GetMapping("/my/search")
    public ResponseEntity<List<GuideInfoDTO>> searchMyGuides(
            @RequestParam(required = false) String search,
            @RequestParam(required = false) String city,
            @RequestParam(required = false) String status,
            @SessionAttribute("user") UserDTO user) { // 세션에서 UserDTO를 가져옴

        if (user == null) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(new ArrayList<>());
        }

        String userId = user.getId();
        List<GuideInfoDTO> guides = guideListService.searchMyGuides(search, city, status, userId);
        return new ResponseEntity<>(guides, HttpStatus.OK);
    }

/*    @GetMapping("/list/{guideInfoId}")
    public ResponseEntity<GuideInfoDTO> getGuideByIdJson(@PathVariable int guideInfoId) {
        GuideInfoDTO guide = guideListService.getGuideById(guideInfoId);
        return new ResponseEntity<>(guide, HttpStatus.OK);
    }*/

    @GetMapping("/list/{guideInfoId}")
    public String getGuideById(@PathVariable int guideInfoId, Model model) {
        GuideInfoDTO guide = guideListService.getGuideById(guideInfoId);
        model.addAttribute("guide", guide);
        return "guide/guide_detail"; // guide_detail.html 렌더링
    }


    @PutMapping("/list/{guideInfoId}/all")
    public ResponseEntity<Void> updateGuide(@PathVariable int guideInfoId, @RequestBody GuideInfoDTO guideInfo) {
        guideInfo.setGuideInfoId(guideInfoId);
        guideListService.updateGuide(guideInfo);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


    @PutMapping("/list/{guideInfoId}/state")
    public ResponseEntity<Void> updateGuideInfoState(@PathVariable int guideInfoId, @RequestBody GuideInfoDTO guideInfo) {
        guideInfo.setGuideInfoId(guideInfoId); // ID 설정
        guideListService.updateGuideInfoState(guideInfo);
        return ResponseEntity.ok().build(); // 성공적으로 업데이트 후 200 OK 반환
    }


    @DeleteMapping("/list/{guideInfoId}")
    public ResponseEntity<Void> deleteGuide(@PathVariable int guideInfoId) {
        guideListService.deleteGuide(guideInfoId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}