package com.example.kosa_first_project.controller.guide;

import com.example.kosa_first_project.domain.guide.GuideInfoDTO;
import com.example.kosa_first_project.service.guide.MyPageGuideListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/guides")
public class MyPageGuideListController {

    @Autowired
    private MyPageGuideListService guideListService;

    @GetMapping
    public ResponseEntity<List<GuideInfoDTO>> getAllGuides() {
        List<GuideInfoDTO> guides = guideListService.getAllGuides();
        return new ResponseEntity<>(guides, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<GuideInfoDTO> getGuideById(@PathVariable int id) {
        GuideInfoDTO guide = guideListService.getGuideById(id);
        return new ResponseEntity<>(guide, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Void> addGuide(@RequestBody GuideInfoDTO guideInfo) {
        guideListService.addGuide(guideInfo);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateGuide(@PathVariable int id, @RequestBody GuideInfoDTO guideInfo) {
        guideInfo.setGuideInfoId(id); // ID 설정
        guideListService.updateGuide(guideInfo);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteGuide(@PathVariable int id) {
        guideListService.deleteGuide(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
