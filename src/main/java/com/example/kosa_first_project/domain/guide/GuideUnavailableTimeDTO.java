package com.example.kosa_first_project.domain.guide;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class GuideUnavailableTimeDTO {

    private int id;
    private String guideId;
    private String userId;
    private LocalDateTime unavailableStartDate;
    private LocalDateTime unavailableEndDate;


}
