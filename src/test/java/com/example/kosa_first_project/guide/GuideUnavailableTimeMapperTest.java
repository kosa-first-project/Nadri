package com.example.kosa_first_project.guide;

import com.example.kosa_first_project.domain.guide.GuideUnavailableTimeDTO;
import mybatis.dao.guide.GuideUnavailableTimeMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class GuideUnavailableTimeMapperTest {

    @Autowired
    private GuideUnavailableTimeMapper guideUnavailableTimeMapper;

    @BeforeEach
    void printLine() {
        System.out.println("=".repeat(80));
    }

    @Test
    public void testInsertGuideUnavailableTime() {
        GuideUnavailableTimeDTO unavailableTime = new GuideUnavailableTimeDTO();
        unavailableTime.setGuideInfoId("guide1");
        unavailableTime.setUserId("user1");
        unavailableTime.setUnavailableStartDate(LocalDateTime.now().plusDays(1));
        unavailableTime.setUnavailableEndDate(LocalDateTime.now().plusDays(2));

        guideUnavailableTimeMapper.insertGuideUnavailableTime(unavailableTime);

        // 데이터베이스에서 확인
        GuideUnavailableTimeDTO fetchedUnavailableTime = guideUnavailableTimeMapper.getGuideUnavailableTimeById(unavailableTime.getGuideUnavailableTimeId());
        assertNotNull(fetchedUnavailableTime);


        // 삽입된 데이터 출력
        System.out.println("삽입된 가이드 비활성화 시간: " + fetchedUnavailableTime);


        // 전체 비활성화 시간 목록 출력
        List<GuideUnavailableTimeDTO> allUnavailableTimes = guideUnavailableTimeMapper.getAllGuideUnavailableTimes();
        System.out.println("현재 가이드 비활성화 시간 정보:");
        allUnavailableTimes.forEach(System.out::println);
    }

    @Test
    public void testGetGuideUnavailableTimeById() {
        GuideUnavailableTimeDTO unavailableTime = guideUnavailableTimeMapper.getGuideUnavailableTimeById(1); // ID가 1인 경우
        assertNotNull(unavailableTime);
        System.out.println("가이드 비활성화 시간 정보: " + unavailableTime);
    }

    @Test
    public void testGetAllGuideUnavailableTimes() {
        List<GuideUnavailableTimeDTO> times = guideUnavailableTimeMapper.getAllGuideUnavailableTimes();

        // 모든 비활성화 시간 정보 출력
        if (times.isEmpty()) {
            System.out.println("가이드 비활성화 시간 정보가 없습니다.");
        } else {
            System.out.println("모든 가이드 비활성화 시간 정보:");
            times.forEach(System.out::println);
        }
    }

    @Test
    public void testUpdateGuideUnavailableTime() {
        GuideUnavailableTimeDTO unavailableTime = guideUnavailableTimeMapper.getGuideUnavailableTimeById(1); // ID가 1인 경우
        unavailableTime.setUnavailableEndDate(LocalDateTime.now().plusDays(3));
        guideUnavailableTimeMapper.updateGuideUnavailableTime(unavailableTime);

        GuideUnavailableTimeDTO updatedTime = guideUnavailableTimeMapper.getGuideUnavailableTimeById(1);
        System.out.println("업데이트된 가이드 비활성화 시간 정보: " + updatedTime);
    }

    @Test
    public void testDeleteGuideUnavailableTime() {
        guideUnavailableTimeMapper.deleteGuideUnavailableTime(2); // ID가 2인 경우
        GuideUnavailableTimeDTO deletedTime = guideUnavailableTimeMapper.getGuideUnavailableTimeById(2);
        System.out.println(deletedTime == null ? "가이드 비활성화 시간 정보 삭제 성공" : "가이드 비활성화 시간 정보 삭제 실패");
    }
}
