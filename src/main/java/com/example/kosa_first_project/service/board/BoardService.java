package com.example.kosa_first_project.service.board;

import com.example.kosa_first_project.domain.board.BoardDTO;
import com.example.kosa_first_project.domain.board.FileDTO;
import lombok.extern.slf4j.Slf4j;
import mybatis.dao.board.BoardMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.http.ContentDisposition;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
public class BoardService{

    @Autowired
    private BoardMapper boardMapper; // 매퍼 객체 생성

    // 게시판 전체 리스트 조회
    public List<BoardDTO> getBoardAll(BoardDTO dto) {
        return boardMapper.getBoardAll(dto);
    }

    //게시판 개별 조회
    public BoardDTO getBoardOne(long id){
        return boardMapper.getBoardOne(id);
    }

    // 게시글 삭제
    public boolean deleteBoard(long id) {
        return boardMapper.deleteBoard(id);
    }

    //게시글 등록, 업데이트
    public void insertBoard(BoardDTO dto) {
        if(dto.getId() != null){ // 게시글 번호가 있으면 삭제
            boardMapper.deleteFile(dto);
        }
        if(dto.getId() != null){ // 게시글 번호가 있으면 업데이트
            boardMapper.updateBoard(dto);
        } else {
            boardMapper.insertBoard(dto); // 게시글 번호가 없으면(NULL) 게시글 삽입
        }

        // 파일 고유 이름 생성
        List<FileDTO> list = new ArrayList<>();
        String[] uuids = dto.getUuids();
        String[] fileNames = dto.getFileNames();
        String[] contentTypes = dto.getContentTypes();

        if(uuids!=null){ // 파일이 존재하면
            for(int i = 0; i < uuids.length; i++){
                FileDTO FileDTO = new FileDTO();
                FileDTO.setUuid(uuids[i]);
                FileDTO.setFileName(fileNames[i]);
                FileDTO.setContentType(contentTypes[i]);
                list.add(FileDTO); // 이미지 추가
            }
        }
        //첨부파일 등록
        if(!list.isEmpty()){
            dto.setList(list);
            boardMapper.insertFile(dto);
        }
    }

    //첨부파일 조회
    public List<FileDTO> getFile(BoardDTO dto) {
        return boardMapper.getFile(dto);
    }

    // 게시글 개수
    public Integer cntBoard(){
        return boardMapper.cntBoard();
    }

    //파일 다운로드
    public ResponseEntity<Resource> downloadFile(FileDTO fileDTO) throws IOException {
        //파일 저장 경로 설정
        String filePath = "d:\\image";
        Path path = Paths.get(filePath + "/" + fileDTO.getUuid() + "_" + fileDTO.getFileName());
        String contentType = Files.probeContentType(path);

        //Header를 통해 다운로드 되는 파일의 정보를 설정
        HttpHeaders headers = new HttpHeaders();
        headers.setContentDisposition(ContentDisposition.builder("attachment")
                .filename(fileDTO.getFileName(), StandardCharsets.UTF_8).build());
        headers.add(HttpHeaders.CONTENT_TYPE, contentType);

        Resource resource = new InputStreamResource(Files.newInputStream(path));

        return new ResponseEntity<>(resource, headers, HttpStatus.OK);
    }
}
