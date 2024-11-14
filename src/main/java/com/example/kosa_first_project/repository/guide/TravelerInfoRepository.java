package com.example.kosa_first_project.repository.guide;

import com.example.kosa_first_project.domain.guide.TravelerInfoDTO;
import mybatis.dao.guide.TravelerInfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TravelerInfoRepository {

    @Autowired
    private TravelerInfoMapper travelerInfoMapper; // MyBatis Mapper 주입

    public void save(TravelerInfoDTO travelerInfoDTO) {
        travelerInfoMapper.insertTravelerInfo(travelerInfoDTO); // Mapper를 통해 DB에 저장
    }

    public TravelerInfoDTO getById(int travelerInfoId) {
        return travelerInfoMapper.getTravelerInfoById(travelerInfoId); // ID로 정보 조회
    }

    public List<TravelerInfoDTO> getAll() {
        return travelerInfoMapper.getAllTravelerInfo(); // 모든 정보 조회
    }

    public void update(TravelerInfoDTO travelerInfoDTO) {
        travelerInfoMapper.updateTravelerInfo(travelerInfoDTO); // 정보 업데이트
    }

    public void delete(int travelerInfoId) {
        travelerInfoMapper.deleteTravelerInfo(travelerInfoId); // 정보 삭제
    }
}
