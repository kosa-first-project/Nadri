package com.example.kosa_first_project.domain.guide;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class GuideUnavableTimeDTO {

    private int id;
    private String guideId;
    private String userId;
    private LocalDateTime unavaiableStartDate;
    private LocalDateTime unavaiableEndDate;


}
