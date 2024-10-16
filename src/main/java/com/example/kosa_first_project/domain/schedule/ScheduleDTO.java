package com.example.kosa_first_project.domain.schedule;

import lombok.*;

import java.util.List;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class ScheduleDTO {
    private List<ScheduleDateDTO> schedule;
}
