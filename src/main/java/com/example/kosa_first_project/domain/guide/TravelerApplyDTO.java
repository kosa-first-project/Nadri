package com.example.kosa_first_project.domain.guide;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class TravelerApplyDTO {

    private int id;
    private int travelerId;
    private int guideId;
    private LocalDateTime applyTime;
    private LocalDateTime acceptTime;
    private LocalDateTime cancelTime;
    private LocalDateTime doneTime;
    private String state;


}
