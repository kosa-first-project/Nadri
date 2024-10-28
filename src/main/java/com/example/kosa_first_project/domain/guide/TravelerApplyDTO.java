package com.example.kosa_first_project.domain.guide;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class TravelerApplyDTO {

    private int travelerApplyId;
    private int travelerInfoId;
    private int guideInfoId;
    private LocalDateTime applyTime;
    private LocalDateTime acceptTime;
    private LocalDateTime cancelTime;
    private LocalDateTime doneTime;
    private String travelerApplyState;


}
