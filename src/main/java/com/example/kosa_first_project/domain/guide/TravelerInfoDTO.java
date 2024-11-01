package com.example.kosa_first_project.domain.guide;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class TravelerInfoDTO {

    private int travelerInfoId;
    private int guideInfoId;
    private String userId;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private String phone;
    private String name;
    private String email;
    private String message;
    private LocalDateTime applyTime;
    private String travelerInfoState;


}
