package com.example.kosa_first_project.domain.schedule;

import lombok.*;

import java.util.Date;

@Getter
@Setter

@NoArgsConstructor
@AllArgsConstructor
public class ScheduleBlockDTO {
    private String destination;
    private Date startDateTime;
    private Date endDateTime;
    private String comment;
    private String user_id;
    private String title;

    @Override
    public String toString(){
        return startDateTime + " ~ " + endDateTime + " - " + destination;
    }
}
