package com.example.kosa_first_project.domain.schedule;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ScheduleDTO {
    private String title;
    private String user_id;
    private List<ScheduleBlockDTO> scheduleList;
}
