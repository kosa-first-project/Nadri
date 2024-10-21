package com.example.kosa_first_project.service.board;

import com.example.kosa_first_project.WebConfig.RequestList;
import com.example.kosa_first_project.domain.board.BoardDTO;
import com.example.kosa_first_project.domain.board.BoardFileDTO;
import lombok.extern.slf4j.Slf4j;
import mybatis.dao.board.BoardMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;

@Slf4j
@Service
public class BoardService {

    @Autowired
    private BoardMapper boardMapper; // 매퍼 연결

    // 게시판 전체 조회
    public List<BoardDTO> getBoardAll() {
        return boardMapper.getBoardAll();
    }

    //게시글 상세 조회
    public BoardDTO getBoardOne(Long id) {
        return boardMapper.getBoardOne(id);
    }

    // 게시글 삭제
    public void deleteBoard(Long id) {
        boardMapper.deleteBoard(id);
    }

    // 게시글 수정
    public void updateBoard(BoardDTO dto) {
        boardMapper.updateBoard(dto);
    }

    //첨부파일 조회
    public List<BoardFileDTO> getFile(Long id) {
        return boardMapper.getFile(id);
    }

    // 게시글 개수
    public Integer cntBoard() {
        return boardMapper.cntBoard();
    }

    //조회 수 증가
    public void updateHit(Long id) {
        boardMapper.updateHit(id);
    }

    //게시글 등록
    public void insertBoard(BoardDTO dto) throws IOException {
        // 게시글 등록 전에 id 값 확인
        System.out.println(dto.getId());

        // 게시글 저장
        if (dto.getBoardFile().get(0).isEmpty()) {
            // 파일이 없을 때
            dto.setFileAttached(0);
            boardMapper.insertBoard(dto);  // 게시글 등록
        } else {
            // 파일 있을 때
            dto.setFileAttached(1);
            boardMapper.insertBoard(dto);  // 게시글 등록 후 ID 값을 받아오기 위해 먼저 호출

            // 게시글 ID 값을 업데이트
            System.out.println("Inserted Board ID: " + dto.getId());  // ID 확인

            // 파일만 따로 가져오기
            for (MultipartFile boardFile : dto.getBoardFile()) {
                // 파일 이름
                String originalFileName = boardFile.getOriginalFilename();
                System.out.println("originalFileName: " + originalFileName);

                // 저장용 이름 만들기
                String storeFileName = System.currentTimeMillis() + "-" + originalFileName;
                System.out.println("storeFileName: " + storeFileName);

                // BoardFileDTO 설정
                BoardFileDTO boardFileDTO = new BoardFileDTO();
                boardFileDTO.setOriginalFileName(originalFileName);
                boardFileDTO.setStoredFileName(storeFileName);
                boardFileDTO.setBoard_id(dto.getId());  // 게시글 저장 후 id 값 활용

                // 파일 저장용 폴더에 파일 저장 처리
                String savePath = "C:\\kosa_first_project\\uploadImage\\" + storeFileName; // 절대 경로
                boardFile.transferTo(new File(savePath)); // 경로로 전송

                // board_file 테이블에 저장
                boardMapper.insertFile(boardFileDTO);
            }
        }
    }

    //게시물 검색
    public List<BoardDTO> searchBoardByKeyword(String keyword) {
        return boardMapper.searchBoardByKeyword(keyword);
    }

    //페이지네이션
    public Page<Map<String, Object>> getListBoard(BoardDTO board, Pageable pageable) {

        // 빌더 패턴으로 data, pageable 파라미터에 데이터 주입
        RequestList<?> requestList = RequestList.builder()
                .data(board)
                .pageable(pageable)
                .build();

        List<Map<String, Object>> content = boardMapper.getListBoard(requestList);
        int total = boardMapper.getListBoardCount(board);

        return new PageImpl<>(content, pageable, total);
    }


}
