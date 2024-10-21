package com.example.kosa_first_project.controller.guide;

import com.example.kosa_first_project.domain.guide.GuideInfoDTO;
import com.example.kosa_first_project.service.guide.GuideListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping
    public ResponseEntity<List<GuideInfoDTO>> getAllGuides() {
        List<GuideInfoDTO> guides = guideListService.getAllGuides();
        return new ResponseEntity<>(guides, HttpStatus.OK);
    }

    @GetMapping("/list")
    public String getAllGuides(Model model) {
        List<GuideInfoDTO> guides = guideListService.getAllGuides();
        model.addAttribute("guides", guides);
        return "guide/guide_list"; // HTML 템플릿 파일 경로
    }


    @GetMapping("/search")
    public ResponseEntity<List<GuideInfoDTO>> searchGuides(
            @RequestParam(required = false) String search,
            @RequestParam(required = false) String city) {
        List<GuideInfoDTO> guides = guideListService.searchGuides(search, city);
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


    @PutMapping("/list/{guideInfoId}")
    public ResponseEntity<Void> updateGuide(@PathVariable int guideInfoId, @RequestBody GuideInfoDTO guideInfo) {
        guideInfo.setGuideInfoId(guideInfoId);
        guideListService.updateGuide(guideInfo);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


    @PutMapping("/{guideInfoId}/state")
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