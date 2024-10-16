package com.example.kosa_first_project.login;

import com.example.kosa_first_project.domain.login.LoginUserDTO;
import mybatis.dao.login.JoinMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import java.time.LocalDateTime;


@SpringBootTest
public class MapperTest {
    @Autowired
    JoinMapper joinMapper;

   @Test
    @Transactional
    public void joinTest() {
        LoginUserDTO user = new LoginUserDTO();
        user.setId("dd");
        user.setPassword("123456");
        user.setUsername("admin");
        user.setPhone("01000001111");
        user.setGender("M");
        user.setNickname("ll");
        user.setEmail("admin@gmail.com");
        user.setCreate_date(LocalDateTime.now());
        user.setGuide_activate("Y");

        //joinMapper.joinUser(user);
   }
}
