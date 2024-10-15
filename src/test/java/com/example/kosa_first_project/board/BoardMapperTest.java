package com.example.kosa_first_project.board;

import com.example.kosa_first_project.domain.board.BoardDTO;
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

    @BeforeEach
    void printLine() {
        System.out.println("=".repeat(80));
    } // 각 테스트 수행하기 전에 출력

    @Test
    @Transactional
    void userSave() {
        BoardDTO boardDTO = new BoardDTO();
        boardDTO.setUser_id("테스터1");
        System.out.println(boardDTO.getUser_id());
    }

    @Test
    @Transactional // 삽입이 됐는지 확인 후 rollback
    void boardSave() {
        BoardDTO boardDTO = new BoardDTO();
        boardDTO.setUser_id(userSave());
        boardDTO.setTitle("제목");
        boardDTO.setContext("내용");
        boardDTO.setImage("첫번째 이미지");
        boardDTO.setRating(5);
        boardMapper.boardSave(boardDTO);

        List<BoardDTO> findAll = boardMapper.findAll(); // 전체 게시글 출력
        System.out.println(findAll.size());
    }
}
