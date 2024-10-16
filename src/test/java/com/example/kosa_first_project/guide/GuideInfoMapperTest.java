package com.example.kosa_first_project.guide;

import com.example.kosa_first_project.domain.guide.GuideInfoDTO;
import mybatis.dao.guide.GuideInfoMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest //단위테스트 클래스로 역할 함에 있어서 내부적으로 처리되도록
public class GuideInfoMapperTest {

    @Autowired
    GuideInfoMapper dao;

    @BeforeEach //각각의 테스트메서드가 수행되기 전에
    void printLine() {
        System.out.println("=".repeat(80));
    }

    @Autowired
    private GuideInfoMapper guideInfoMapper;

    @Test
    public void testInsertGuideInfo() {
        GuideInfoDTO guideInfo = new GuideInfoDTO();
        guideInfo.setUserId("user5");
        guideInfo.setCity("Seoul");
        guideInfo.setTown("Gangnam");
        guideInfo.setVillage("Yeoksam");
        guideInfo.setName("John Doe");
        guideInfo.setTitle("Professional Tour Guide");
        guideInfo.setCareer("5 years");
        guideInfo.setCapacity(10);
        guideInfo.setText("Welcome to my tour!");
        guideInfo.setWeekdayPrice(1000);
        guideInfo.setWeekendPrice(1500);
        guideInfo.setBoardRating(4.5);
        guideInfo.setLikeCount(100);
        guideInfo.setState("activate");

        guideInfoMapper.insertGuideInfo(guideInfo);

        // ID가 생성되었는지 확인
        assertNotNull(guideInfo.getId());

        // 데이터베이스에서 확인
        GuideInfoDTO fetchedGuideInfo = guideInfoMapper.getGuideInfoById(guideInfo.getId());
        assertNotNull(fetchedGuideInfo);

        // 삽입된 가이드 정보 출력
        System.out.println("삽입된 가이드 정보: " + fetchedGuideInfo);
    }

    @Test
    public void testGetGuideInfoById() {
        GuideInfoDTO guideInfo = guideInfoMapper.getGuideInfoById(4);
        assertNotNull(guideInfo);
        System.out.println("가이드 정보: " + guideInfo);
    }

    @Test
    public void testGetAllGuideInfo() {
        List<GuideInfoDTO> guides = guideInfoMapper.getAllGuideInfo();

        // 가이드 정보 출력
        if (guides.isEmpty()) {
            System.out.println("가이드 정보가 없습니다.");
        } else {
            System.out.println("모든 가이드 정보:");
            guides.forEach(System.out::println);
        }
    }

    @Test
    public void testUpdateGuideInfo() {
        GuideInfoDTO guideInfo = guideInfoMapper.getGuideInfoById(4);
        guideInfo.setName("Jane Doe");
        guideInfoMapper.updateGuideInfo(guideInfo);

        GuideInfoDTO updatedGuide = guideInfoMapper.getGuideInfoById(4);
        System.out.println("업데이트된 가이드 정보: " + updatedGuide);
    }

    @Test
    public void testDeleteGuideInfo() {
        guideInfoMapper.deleteGuideInfo(3);
        GuideInfoDTO deletedGuide = guideInfoMapper.getGuideInfoById(3);
        System.out.println(deletedGuide == null ? "가이드 정보 삭제 성공" : "가이드 정보 삭제 실패");
    }
}
