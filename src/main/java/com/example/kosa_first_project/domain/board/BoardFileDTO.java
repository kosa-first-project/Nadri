package com.example.kosa_first_project.domain.board;

import lombok.Data;
/**
 * id               첨부파일 고유식별자
 * boardId          게시글 고유식별자
 * originalFilename 원본첨부파일이름
 * storedFilename   DB에 저장될 첨부파일 고유이름
 */
@Data
public class BoardFileDTO {
    private Long id;
    private Long boardId;
    private String originalFilename;
    private String storedFilename;
}
