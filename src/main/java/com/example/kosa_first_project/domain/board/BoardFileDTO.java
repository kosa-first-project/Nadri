package com.example.kosa_first_project.domain.board;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data // getter, setter
@AllArgsConstructor // 클래스에 존재하는 모든 생성자
@NoArgsConstructor // 파라미터가 없는 기본 생성자
public class BoardFileDTO {
    private long id; // 파일 id
    private long board_id; // 게시판 번호(외래키)
    private String originalFileName; // 기존 파일명
    private String storedFileName; // 저장된 파일명
}
