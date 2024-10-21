package com.example.kosa_first_project.service.guide;

import com.example.kosa_first_project.domain.guide.GuideInfoDTO;
import com.example.kosa_first_project.repository.guide.GuideListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class GuideListService {

    @Autowired
    private GuideListRepository guideListRepository;

    public List<GuideInfoDTO> getAllGuides() {
        return guideListRepository.getAllGuideInfo();
    }

    public List<GuideInfoDTO> searchGuides(String search, String city) {
        if (search == null || search.isEmpty()) {
            return guideListRepository.getAllGuideInfo(); // 검색어가 없으면 모든 가이드를 반환
        }
        return guideListRepository.searchGuides(search, city);
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
