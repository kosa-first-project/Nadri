package com.example.kosa_first_project.controller;

import com.example.kosa_first_project.domain.DomainTest;
import org.springframework.stereotype.Controller;

@Controller
public class ControllerTest {

    public ControllerTest(){
        DomainTest dto = new DomainTest("컨트롤러, 도메인 테스트");
        System.out.println(dto.getTestName());
    }
}
