package com.example.kosa_first_project.domain.guide;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
public class GuideUnavailableTimeDTO {

    private int guideUnavailableTimeId;
    private int guideInfoId;
    private String userId;
    private LocalDate unavailableStartDate;
    private LocalDate unavailableEndDate;


}
