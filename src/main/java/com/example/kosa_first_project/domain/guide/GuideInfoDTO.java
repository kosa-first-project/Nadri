package com.example.kosa_first_project.domain.guide;
import lombok.Data;

import java.util.List;

@Data
public class GuideInfoDTO {


    private int guideInfoId;
    private String userId;
    private String city;
    private String town;
    private String village;
    private String name;
    private String title;
    private String career;
    private int capacity;
    private String text;
    private int weekdayPrice;
    private int weekendPrice;
    private double boardRating;
    private int likeCount;
    private String guideInfoState;


    // 불가능 기간 리스트를 포함
    private List<GuideUnavailableTimeDTO> unavailableDates;

    //user 테이블과 조인해서 닉네임 받기
    private String nickname;

}
