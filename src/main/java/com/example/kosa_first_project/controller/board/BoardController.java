package com.example.kosa_first_project.controller.board;

import com.example.kosa_first_project.domain.board.BoardDTO;
import lombok.extern.slf4j.Slf4j;
import mybatis.dao.board.BoardMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Slf4j
@Controller
public class BoardController {

    @Autowired
    BoardMapper dao;

    @GetMapping("/board") // 주소
    public String boardIndex() { // 메서드 이름
        return "boardIndex"; // 리턴할 화면의 이름
    }

    @GetMapping("/boardWrite")
    public String boardWrite(){

        return "boardWrite";
    }

    @PostMapping("/boardSave")
    public String boardSave(Model model){
        model.addAttribute("boardDTO", new BoardDTO());
        log.info(model.toString());

        return "boardDTO";
    }

}
