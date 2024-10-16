package com.example.kosa_first_project.domain.schedule;

import lombok.*;

import java.util.Date;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class ScheduleDateDTO {
    private String destination;
    private Date startDateTime;
    private Date endDateTime;
}
