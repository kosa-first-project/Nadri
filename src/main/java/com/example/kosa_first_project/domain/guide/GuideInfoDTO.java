package com.example.kosa_first_project.domain.guide;
import lombok.Data;

@Data
public class GuideInfoDTO {


    private int id;
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
    private String state;


}
