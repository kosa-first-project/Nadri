package com.example.kosa_first_project.domain.board;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data // getter, setter
@AllArgsConstructor // 클래스에 존재하는 모든 생성자
@NoArgsConstructor // 파라미터가 없는 기본 생성자
public class FileDTO {
    private String fileName; // 파일 이름
    private String uuid; // 고유 번호
    private String contentType; // 파일 종류
}
