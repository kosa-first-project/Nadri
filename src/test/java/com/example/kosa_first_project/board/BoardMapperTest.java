package com.example.kosa_first_project.board;

import com.example.kosa_first_project.domain.board.BoardDTO;
import com.example.kosa_first_project.domain.board.BoardFileDTO;
import com.example.kosa_first_project.repository.board.mybatis.BoardMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

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
    void saveByForeach() {
        for (int i = 1; i <= 1000; i++) {
            BoardDTO params = new BoardDTO();
            params.setTitle(i + "번 게시글 제목");
            params.setContent(i + "번 게시글 내용");
        }
    }

    @Test
    @Transactional
    void userSave() { // 회원 저장
        BoardDTO boardDTO = new BoardDTO();
    }

    @Test
    @Transactional  // 게시글 저장
    void insertBoard() {
        BoardDTO boardDTO = new BoardDTO();
        boardDTO.setTitle("테스트1");
        boardDTO.setContent("게시판 테스트1");
//        boardDTO.setImage("게시판 이미지 테스트1");
    }

    @Test
    @Transactional
    void getBoardAll() { // 전체 게시글 출력
        BoardDTO boardDTO = new BoardDTO();
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
        BoardFileDTO fileDTO = new BoardFileDTO();
    }
    

}
