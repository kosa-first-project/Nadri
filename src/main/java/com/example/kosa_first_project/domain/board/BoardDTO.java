package com.example.kosa_first_project.domain.board;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * id             게시글 고유식별자
 * title          게시글 제목
 * content        게시글 내용
 * author         게시글 작성작
 * viewCount      게시글 조회수
 * createdDate    게시글 생성일
 * attachedFile   첨부파일 유무
 * boardFile      첨부파일 리스트
 */
@Data
public class BoardDTO {

    private Long id;
    private String title;
    private String content;
    private String author;
    private String boardPass;
    private Integer viewCount;
    private String createdDate;
    private Integer attachedFile;
    private List<MultipartFile> boardFile;
    private List<BoardFileDTO> boardFiles;
}
