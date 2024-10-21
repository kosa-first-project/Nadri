package com.example.kosa_first_project.repository.guide;

import com.example.kosa_first_project.domain.guide.GuideInfoDTO;
import mybatis.dao.guide.GuideInfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class GuideListRepository {

    @Autowired
    private GuideInfoMapper guideInfoMapper;

    public void insertGuideInfo(GuideInfoDTO guideInfo) {
        guideInfoMapper.insertGuideInfo(guideInfo);
    }

    public GuideInfoDTO getGuideInfoById(int guideInfoId) {
        return guideInfoMapper.getGuideInfoById(guideInfoId);
    }

    public List<GuideInfoDTO> getAllGuideInfo() {
        return guideInfoMapper.getAllGuideInfo();
    }

/*
    public List<GuideInfoDTO> searchGuides(String search, String city) {
        return guideInfoMapper.searchGuides(search, city);
    }*/

    public List<GuideInfoDTO> searchGuides(String search, String city, String status) {
        return guideInfoMapper.searchGuides(search, city, status);
    }

    public void updateGuideInfo(GuideInfoDTO guideInfo) {
        guideInfoMapper.updateGuideInfo(guideInfo);
    }


    public void updateGuideInfoState(GuideInfoDTO guideInfo) {
        guideInfoMapper.updateGuideInfoState(guideInfo);
    }

    public void deleteGuideInfo(int guideInfoId) {
        guideInfoMapper.deleteGuideInfo(guideInfoId);
    }
}
