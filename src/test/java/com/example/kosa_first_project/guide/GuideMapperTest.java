package com.example.kosa_first_project.guide;

import com.example.kosa_first_project.domain.guide.GuideInfoDTO;
import mybatis.dao.guide.GuideMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;

//@ExtendWith(SpringExtension.class)
@SpringBootTest //단위테스트 클래스로 역할 함에 있어서 내부적으로 처리되도록
public class GuideMapperTest {

        @Autowired
        GuideMapper dao;

        @BeforeEach //각각의 테스트메서드가 수행되기 전에
        void printLine() {
            System.out.println("=".repeat(80));
        }



        @Autowired
        private GuideMapper.GuideInfoMapper guideInfoMapper;

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
    }

        @Test
        public void testGetGuideInfoById() {
            GuideInfoDTO guideInfo = guideInfoMapper.getGuideInfoById(1);
            //assertNotNull(guideInfo);
            //assertEquals("John Doe", guideInfo.getName());
        }

        @Test
        public void testGetAllGuideInfo() {
            List<GuideInfoDTO> guides = guideInfoMapper.getAllGuideInfo();
            //assertFalse(guides.isEmpty());
        }

        @Test
        public void testUpdateGuideInfo() {
            GuideInfoDTO guideInfo = guideInfoMapper.getGuideInfoById(4);
            guideInfo.setName("Jane Doe");
            guideInfoMapper.updateGuideInfo(guideInfo);

            GuideInfoDTO updatedGuide = guideInfoMapper.getGuideInfoById(1);
            //assertEquals("Jane Doe", updatedGuide.getName());
        }

        @Test
        public void testDeleteGuideInfo() {
            guideInfoMapper.deleteGuideInfo(3);
            //assertNull(guideInfoMapper.getGuideInfoById(1));
        }
}



        /*
        @Test
        void test1() {
            dao.listAll().stream().forEach(System.out :: println);
        }
        @Test
        void test2() {
            dao.listOrderByScoreDesc().stream().forEach(System.out :: println);
        }
        @Test
        void test3() {
            dao.listByScoreGreaterEqualThan70().stream().forEach(System.out :: println);
        }
        @Test
        void test4() {
            dao.listByContainName().stream().forEach(System.out :: println);
        }
        @Test
        void test5() {
            System.out.println(dao.getScore("둘리"));
        }
        @Test
        void test6() {
            System.out.println(dao.getScoreAvg());
        }
        @Test
        @Transactional

        //테스트로 insert한걸 다시 롤백하도록 함.
        void test7() {
            StudentDTO dto = new StudentDTO();
            dto.setName("캐로로");
            dto.setScore(100);
            System.out.println(dao.insert(dto));
            dao.listAll().stream().forEach(System.out :: println);
        }
        @Test
        @Transactional//테스트로 delete한걸 다시 롤백하도록 함.
        void test8() {
            System.out.println(dao.delete("둘리"));
            dao.listAll().stream().forEach(System.out :: println);
        }*/

