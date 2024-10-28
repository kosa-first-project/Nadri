package com.example.kosa_first_project.domain.board;

import lombok.Data;

/**
 * 검색 기능을 위한 개체
 * title 제목
 */
@Data
public class TitleSearchCond {
    private String title;
    public TitleSearchCond() {
    }
    public TitleSearchCond(String title) {
        this.title = title;
    }
}
