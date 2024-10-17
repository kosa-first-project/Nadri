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
    private String description = "";

    public ScheduleBlockDTO(String destination, Date startDateTime, Date endDateTime) {
        this.destination = destination;
        this.startDateTime = startDateTime;
        this.endDateTime = endDateTime;
    }

    @Override
    public String toString(){
        return startDateTime + " ~ " + endDateTime + " - " + destination;
    }
}
