package com.example.kosa_first_project.board;

import com.example.kosa_first_project.domain.board.BoardDTO;
import com.example.kosa_first_project.domain.board.FileDTO;
import mybatis.dao.board.BoardMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@SpringBootTest // 단위 테스트 클래스 설정
public class BoardMapperTest {
    @Autowired
    BoardMapper boardMapper;

    // 각 테스트 수행하기 전에 출력
    @BeforeEach
    void printLine() {
        System.out.println("=".repeat(80));
    }

    @Test
    @Transactional
    void userSave() { // 회원 저장
        BoardDTO boardDTO = new BoardDTO();
        boardDTO.setUser_id("테스터1");
        System.out.println(boardDTO.getUser_id());
    }

    @Test
    @Transactional  // 게시글 저장
    void insertBoard() {
        BoardDTO boardDTO = new BoardDTO();
        boardDTO.setUser_id("dohun");
        boardDTO.setTitle("테스트1");
        boardDTO.setContent("게시판 테스트1");
//        boardDTO.setImage("게시판 이미지 테스트1");
        boardDTO.setRating(5);
    }

    @Test
    @Transactional
    void getBoardAll() { // 전체 게시글 출력
        BoardDTO boardDTO = new BoardDTO();
        List<BoardDTO> findAll = boardMapper.getBoardAll(boardDTO);
        System.out.println(findAll.size());
    }

    @Test
    @Transactional
    void getBoardOne(){ // 게시글 상세
        BoardDTO boardDTO = new BoardDTO();
//        BoardDTO fineOne = boardMapper.getBoardOne(boardDTO.getId());
//        System.out.println(fineOne);
    }

    @Test
    @Transactional
    void insertFile(){ // 파일 저장
        FileDTO fileDTO = new FileDTO();
    }
    

}
