package com.example.kosa_first_project.service.guide;

import com.example.kosa_first_project.domain.guide.TravelerInfoDTO;
import com.example.kosa_first_project.repository.guide.TravelerInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TravelerInfoService {

    @Autowired
    private TravelerInfoRepository travelerInfoRepository; // Repository 주입

    public void save(TravelerInfoDTO travelerInfoDTO) {
        travelerInfoRepository.save(travelerInfoDTO); // Repository를 통해 DB에 저장
    }

    public TravelerInfoDTO getById(int travelerInfoId) {
        return travelerInfoRepository.getById(travelerInfoId); // ID로 정보 조회
    }

    public List<TravelerInfoDTO> getAll() {
        return travelerInfoRepository.getAll(); // 모든 정보 조회
    }

    public void update(TravelerInfoDTO travelerInfoDTO) {
        travelerInfoRepository.update(travelerInfoDTO); // 정보 업데이트
    }

    public void delete(int travelerInfoId) {
        travelerInfoRepository.delete(travelerInfoId); // 정보 삭제
    }
}
