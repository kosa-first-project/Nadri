package com.example.kosa_first_project.login;

import com.example.kosa_first_project.domain.login.JoinUserDTO;
import mybatis.dao.login.JoinMapper; // JoinMapper의 경로 확인
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.boot.test.autoconfigure.MybatisTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import java.time.LocalDateTime;

@MybatisTest
@SpringJUnitConfig
public class JoinMapperTest {

    @Autowired
    private JoinMapper joinMapper;

    @Test
    public void testInsertUser() {
        // Given: 테스트할 사용자 정보 생성
        JoinUserDTO joinUserDTO = new JoinUserDTO();
        joinUserDTO.setId("testuser");
        joinUserDTO.setPassword("password123!");
        joinUserDTO.setUsername("테스트유저");
        joinUserDTO.setPhone("010-1234-5678");
        joinUserDTO.setGender("M");
        joinUserDTO.setNickname("tester");
        joinUserDTO.setEmail("testuser@example.com");
        joinUserDTO.setGuide_activate("Y");
        joinUserDTO.setCreate_date(LocalDateTime.now());

        // When: 사용자 정보 삽입
        joinMapper.save(joinUserDTO); // 반환 값이 없으므로, 결과 확인은 따로 하지 않음

        // Then: 삽입 결과 확인
        JoinUserDTO insertedUser = joinMapper.findById("testuser"); // findById 메서드는 추가로 정의 필요
        Assertions.assertNotNull(insertedUser, "사용자가 정상적으로 삽입되어야 합니다.");
        Assertions.assertEquals("테스트유저", insertedUser.getUsername(), "사용자 이름이 일치해야 합니다.");
        Assertions.assertEquals("testuser@example.com", insertedUser.getEmail(), "이메일이 일치해야 합니다.");
    }
}
