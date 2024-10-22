package com.example.kosa_first_project.service.guide;

import com.example.kosa_first_project.domain.guide.GuideInfoDTO;
import com.example.kosa_first_project.domain.guide.GuideUnavailableTimeDTO;
import mybatis.dao.guide.GuideInfoMapper;
import mybatis.dao.guide.GuideUnavailableTimeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Service
public class GuideFormService {

    @Autowired
    private GuideInfoMapper guideInfoMapper;
    @Autowired
    private GuideUnavailableTimeMapper guideUnavailableTimeMapper;

    public void saveGuideInfo(GuideInfoDTO guideInfoDTO) {
        /*
        // Guide 정보 저장
        guideInfoMapper.insertGuideInfo(guideInfoDTO);

        // Guide 불가능 시간 저장
        if (guideUnavailableTimeDTO.getUnavailableStartDate() != null && guideUnavailableTimeDTO.getUnavailableEndDate() != null) {
            guideUnavailableTimeMapper.insertGuideUnavailableTime(guideUnavailableTimeDTO);
            //guideInfoMapper.insertUnavailableDate(guideInfoDTO.getId(), date);
        }*/

        if (guideInfoDTO.getGuideInfoId() != 0) {
            guideInfoMapper.updateGuideInfo(guideInfoDTO);
        } else {
            guideInfoMapper.insertGuideInfo(guideInfoDTO);
        }

        // 불가능 기간 저장 (있을 경우)
        if (guideInfoDTO.getUnavailableDates() != null) {
            guideInfoDTO.getUnavailableDates().forEach(unavailableTime -> {
                unavailableTime.setGuideInfoId(guideInfoDTO.getGuideInfoId());
                guideUnavailableTimeMapper.insertGuideUnavailableTimeNoUserId(unavailableTime);
            });
        }
    }

    public GuideInfoDTO getGuideInfo(int guideInfoId) {
        return guideInfoMapper.getGuideInfoById(guideInfoId);
    }

}
