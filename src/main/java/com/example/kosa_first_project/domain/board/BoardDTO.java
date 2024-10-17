    package com.example.kosa_first_project.domain.board;

    import lombok.Data;

    import java.time.LocalDateTime;
    import java.util.List;

    @Data // getter, setter, EqualsAndHashCode, RequiredArgsConstructor, Value
    public class BoardDTO {
        private Long id; // 게시글 번호
        private String user_id; // 회원 아이디(외래키)
        private String title; // 제목
        private String content; // 내용
        private String image; // 이미지
        private double rating; // 평점
        private int viewCnt; // 조회수
        private LocalDateTime write_date; // 생성 일시
        private LocalDateTime modify_date; // 최종 수정 일시

        private Integer pageNo; // 현재 페이지 번호
        private int pageSize; // 페이지 당 항목 수
        private int pageOffset; // 현재 페이지 이전 항목 수

        private List<FileDTO> list; // 파일 목록
        private String fileName; // 파일 이름
        private String[] uuids; // 고유번호
        private String[] fileNames; //
        private String[] contentTypes; // 파일 종류
    }
