    package com.example.kosa_first_project.domain.board;

    import lombok.Data;
    import org.springframework.web.multipart.MultipartFile;

    import java.time.LocalDateTime;
    import java.util.List;

    @Data // getter, setter, EqualsAndHashCode, RequiredArgsConstructor, Value
    public class BoardDTO {
        private Long id; // 게시글 번호
        private String user_id; // 회원 아이디(외래키)
        private String title; // 제목
        private String content; // 내용
        private double rating; // 평점
        private int hits; // 조회수
        private String createdAt; // 작성 일시
        private String modifyAt; // 수정 일시
        private int fileAttached; // 파일이 첨부됐는지 확인
        private List<MultipartFile> boardFile; // 파일 목록
/*
        private Integer pageNo; // 현재 페이지 번호
        private int pageSize; // 페이지 당 항목 수
        private int pageOffset; // 현재 페이지 이전 항목 수*/
    }
