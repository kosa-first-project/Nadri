package com.example.kosa_first_project.guide;

import com.example.kosa_first_project.domain.guide.TravelerApplyDTO;
import mybatis.dao.guide.TravelerApplyMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class TravelerApplyMapperTest {

    @Autowired
    private TravelerApplyMapper travelerApplyMapper;

    @BeforeEach
    void printLine() {
        System.out.println("=".repeat(80));
    }

    @Test
    public void testInsertTravelerApply() {
        TravelerApplyDTO apply = new TravelerApplyDTO();
        apply.setTravelerInfoId(1);
        apply.setGuideInfoId(2);
        apply.setApplyTime(LocalDateTime.now());
        apply.setAcceptTime(null);
        apply.setCancelTime(null);
        apply.setDoneTime(null);
        apply.setTravelerApplyState("pending");

        travelerApplyMapper.insertTravelerApply(apply);

        // ID가 생성되었는지 확인
        //assertNotNull(apply.getTravelerInfoId());

        // 데이터베이스에서 확인
        TravelerApplyDTO fetchedApply = travelerApplyMapper.getTravelerApplyById(apply.getTravelerInfoId());
        assertNotNull(fetchedApply);

        // 삽입된 데이터 출력
        System.out.println("삽입된 트레블러 신청 정보: " + fetchedApply);
    }

    @Test
    public void testGetTravelerApplyById() {
        TravelerApplyDTO apply = travelerApplyMapper.getTravelerApplyById(1); // ID가 1인 경우
        assertNotNull(apply);
        System.out.println("트레블러 신청 정보: " + apply);
    }

    @Test
    public void testGetAllTravelerApplies() {
        List<TravelerApplyDTO> applies = travelerApplyMapper.getAllTravelerApplies();

        // 모든 신청 정보 출력
        if (applies.isEmpty()) {
            System.out.println("트레블러 신청 정보가 없습니다.");
        } else {
            System.out.println("모든 트레블러 신청 정보:");
            applies.forEach(System.out::println);
        }
    }

    @Test
    public void testUpdateTravelerApply() {
        TravelerApplyDTO apply = travelerApplyMapper.getTravelerApplyById(1); // ID가 1인 경우
        apply.setTravelerApplyState("accepted");
        apply.setAcceptTime(LocalDateTime.now());
        travelerApplyMapper.updateTravelerApply(apply);

        TravelerApplyDTO updatedApply = travelerApplyMapper.getTravelerApplyById(1);
        System.out.println("업데이트된 트레블러 신청 정보: " + updatedApply);
    }

    @Test
    public void testDeleteTravelerApply() {
        travelerApplyMapper.deleteTravelerApply(2); // ID가 2인 경우
        TravelerApplyDTO deletedApply = travelerApplyMapper.getTravelerApplyById(2);
        System.out.println(deletedApply == null ? "트레블러 신청 정보 삭제 성공" : "트레블러 신청 정보 삭제 실패");
    }
}
