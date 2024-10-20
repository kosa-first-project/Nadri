package com.example.kosa_first_project.controller.guide;

import com.example.kosa_first_project.domain.guide.GuideInfoDTO;
import com.example.kosa_first_project.service.guide.MyPageGuideListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/guides/list")
public class GuideListController {

    @Autowired
    private MyPageGuideListService guideListService;

    @GetMapping
    public ResponseEntity<List<GuideInfoDTO>> getAllGuides() {
        List<GuideInfoDTO> guides = guideListService.getAllGuides();
        return new ResponseEntity<>(guides, HttpStatus.OK);
    }

    @GetMapping("/{guideInfoId}")
    public ResponseEntity<GuideInfoDTO> getGuideById(@PathVariable int guideInfoId) {
        GuideInfoDTO guide = guideListService.getGuideById(guideInfoId);
        return new ResponseEntity<>(guide, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Void> addGuide(@RequestBody GuideInfoDTO guideInfo) {
        guideListService.addGuide(guideInfo);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("/{guideInfoId}")
    public ResponseEntity<Void> updateGuide(@PathVariable int guideInfoId, @RequestBody GuideInfoDTO guideInfo) {
        guideInfo.setGuideInfoId(guideInfoId); // ID 설정
        guideListService.updateGuide(guideInfo);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/{guideInfoId}")
    public ResponseEntity<Void> deleteGuide(@PathVariable int guideInfoId) {
        guideListService.deleteGuide(guideInfoId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
