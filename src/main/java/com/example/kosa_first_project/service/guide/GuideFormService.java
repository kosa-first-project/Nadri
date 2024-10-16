package com.example.kosa_first_project.service.guide;

import com.example.kosa_first_project.domain.guide.GuideInfoDTO;
import com.example.kosa_first_project.domain.guide.GuideUnavailableTimeDTO;
import mybatis.dao.guide.GuideInfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Service
public class GuideFormService {

    @Autowired
    private GuideInfoMapper guideInfoMapper;

    public void saveGuideInfo(GuideInfoDTO guideInfoDTO) {
        // Guide 정보 저장
        guideInfoMapper.insertGuideInfo(guideInfoDTO);

        /*
        // Unavailable dates 저장
        if (guideInfoDTO.getUnavailableStartDates() != null) {
            for (UnavailableDateDTO date : guideInfoDTO.getUnavailableDates()) {
                guideInfoMapper.insertUnavailableDate(guideInfoDTO.getId(), date);
            }
        }*/
    }
}
