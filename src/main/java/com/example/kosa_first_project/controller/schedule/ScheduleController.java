package com.example.kosa_first_project.controller.schedule;

import com.example.kosa_first_project.domain.schedule.ScheduleDateDTO;
import mybatis.dao.schedule.ScheduleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
public class ScheduleController {
    @Autowired
    private ScheduleMapper scheduleMapper;

    @PostMapping("/schedule/Create")
    public String createSchedule(@RequestParam("destination") String destination,
                                 @RequestParam("travel_start_date") String startDate,
                                 @RequestParam("travel_start_time") String startTime,
                                 @RequestParam("travel_end_date") String endDate,
                                 @RequestParam("travel_end_time") String endTime,
                                 Model model) throws ParseException {

        SimpleDateFormat dateTimeFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        Date startDateTime = dateTimeFormat.parse(startDate + " " + startTime);
        Date endDateTime = dateTimeFormat.parse(endDate + " " + endTime);

        // Print combined date and time objects to verify correct parsing
        System.out.println("Parsed Start DateTime: " + startDateTime);
        System.out.println("Parsed End DateTime: " + endDateTime);

        // Create ScheduleDateDTO object
        ScheduleDateDTO scheduleDateDTO = new ScheduleDateDTO(destination, startDateTime, endDateTime);

        // Print the ScheduleDateDTO object to verify its contents
        System.out.println("ScheduleDateDTO: " + scheduleDateDTO);

        // mapper 추가 필
        scheduleMapper.saveSchedule(scheduleDateDTO);

        // Add schedule data to model to display it in a success page
        model.addAttribute("schedule", scheduleDateDTO);

        return "create_Schedule";
    }
}
