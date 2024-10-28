package com.example.kosa_first_project.guide;

import com.example.kosa_first_project.domain.guide.TravelerInfoDTO;
import mybatis.dao.guide.TravelerInfoMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class TravelerInfoMapperTest {

    @Autowired
    private TravelerInfoMapper travelerInfoMapper;

    @BeforeEach
    void printLine() {
        System.out.println("=".repeat(80));
    }

    @Test
    public void testInsertTravelerInfo() {
        TravelerInfoDTO travelerInfo = new TravelerInfoDTO();
        travelerInfo.setGuideInfoId(1); // 가이드 ID가 1인 경우
        travelerInfo.setUserId("traveler1");
        travelerInfo.setName("Alice Smith");
        travelerInfo.setEmail("alice@example.com");
        travelerInfo.setPhone("010-1234-5678");
        travelerInfo.setStartDate(LocalDateTime.now());
        travelerInfo.setEndDate(LocalDateTime.now().plusDays(2));
        travelerInfo.setMessage("투어를 기대하고 있습니다!");
        travelerInfo.setApplyTime(LocalDateTime.now());
        travelerInfo.setTravelerInfoState("active");

        travelerInfoMapper.insertTravelerInfo(travelerInfo);

        // ID가 생성되었는지 확인
        //assertNotNull(travelerInfo.getTravelerInfoId());

        // 데이터가 삽입되었는지 확인
        TravelerInfoDTO fetchedTravelerInfo = travelerInfoMapper.getTravelerInfoById(travelerInfo.getTravelerInfoId());
        assertNotNull(fetchedTravelerInfo);

        // 삽입된 트레블러 정보 출력
        System.out.println("삽입된 트레블러 정보: " + fetchedTravelerInfo);
    }

    @Test
    public void testGetTravelerInfoById() {
        TravelerInfoDTO travelerInfo = travelerInfoMapper.getTravelerInfoById(1); // ID가 1인 경우
        assertNotNull(travelerInfo);
        System.out.println("트레블러 정보: " + travelerInfo);
    }

    @Test
    public void testGetAllTravelerInfo() {
        List<TravelerInfoDTO> travelers = travelerInfoMapper.getAllTravelerInfo();

        // 모든 트레블러 정보 출력
        if (travelers.isEmpty()) {
            System.out.println("트레블러 정보가 없습니다.");
        } else {
            System.out.println("모든 트레블러 정보:");
            travelers.forEach(System.out::println);
        }
    }

    @Test
    public void testUpdateTravelerInfo() {
        TravelerInfoDTO travelerInfo = travelerInfoMapper.getTravelerInfoById(3); // ID가 1인 경우
        travelerInfo.setName("Bob Johnson");
        travelerInfoMapper.updateTravelerInfo(travelerInfo);

        TravelerInfoDTO updatedTraveler = travelerInfoMapper.getTravelerInfoById(1);
        System.out.println("업데이트된 트레블러 정보: " + updatedTraveler);
    }

    @Test
    public void testDeleteTravelerInfo() {
        travelerInfoMapper.deleteTravelerInfo(2); // ID가 2인 경우
        TravelerInfoDTO deletedTraveler = travelerInfoMapper.getTravelerInfoById(2);
        System.out.println(deletedTraveler == null ? "트레블러 정보 삭제 성공" : "트레블러 정보 삭제 실패");
    }
}
