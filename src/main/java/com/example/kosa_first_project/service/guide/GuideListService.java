package com.example.kosa_first_project.service.guide;

import com.example.kosa_first_project.domain.guide.GuideInfoDTO;
import com.example.kosa_first_project.repository.guide.GuideListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GuideListService {

    @Autowired
    private GuideListRepository guideListRepository;

    public List<GuideInfoDTO> getAllGuides() {
        return guideListRepository.getAllGuideInfo();
    }

    public GuideInfoDTO getGuideById(int guideInfoId) {
        return guideListRepository.getGuideInfoById(guideInfoId);
    }

    public void addGuide(GuideInfoDTO guideInfo) {
        guideListRepository.insertGuideInfo(guideInfo);
    }

    public void updateGuide(GuideInfoDTO guideInfo) {
        guideListRepository.updateGuideInfo(guideInfo);
    }


    public void updateGuideInfoState(GuideInfoDTO guideInfo) {
        guideListRepository.updateGuideInfoState(guideInfo);
    }

    public void deleteGuide(int guideInfoId) {
        guideListRepository.deleteGuideInfo(guideInfoId);
    }
}
