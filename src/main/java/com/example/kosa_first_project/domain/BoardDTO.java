package com.example.kosa_first_project.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BoardDTO {
    private Long id;
    private String user_id; // 작성자
    private String title; // 제목
    private String context; // 내용
    private String image; // 이미지
    private double rating; // 평점
    private int viewCnt; // 조회수
    private LocalDateTime write_date; // 생성 일시
    private LocalDateTime modify_date; // 최종 수정 일시
}
