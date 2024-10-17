package com.example.kosa_first_project.controller.schedule;

import com.example.kosa_first_project.domain.schedule.ScheduleBlockDTO;
import com.example.kosa_first_project.domain.schedule.ScheduleDTO;
import jakarta.servlet.http.HttpSession;
import mybatis.dao.schedule.ScheduleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
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
                                 @RequestParam("comment") String comment,
                                 Model model, HttpSession httpSession) throws ParseException {

        SimpleDateFormat dateTimeFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        Date startDateTime = dateTimeFormat.parse(startDate + " " + startTime);
        Date endDateTime = dateTimeFormat.parse(endDate + " " + endTime);
        String title = (String) httpSession.getAttribute("title");
        String userid = "testID";
        // check if the session already have title : if it has one,
        // it means this part will add new schedule of day into existing scheduleDTO
        ScheduleDTO currentSchedule = (ScheduleDTO) httpSession.getAttribute("currentSchedule");

        if (currentSchedule == null) {
            currentSchedule = new ScheduleDTO();
            currentSchedule.setTitle(title);
            currentSchedule.setScheduleList(new ArrayList<>()); // Initialize with an empty list of blocks
            httpSession.setAttribute("currentSchedule", currentSchedule);
        }
        ScheduleBlockDTO scheduleBlockDTO =
                new ScheduleBlockDTO(destination, startDateTime, endDateTime, comment);
        currentSchedule.getScheduleList().add(scheduleBlockDTO);

        // Optionally save the block to the database
        scheduleMapper.saveScheduleBlock(scheduleBlockDTO);

        // Update session with the new schedule
        httpSession.setAttribute("currentSchedule", currentSchedule);

        // Add schedule block data to the model to display in the view (if needed)
        model.addAttribute("schedule", currentSchedule);
        return "redirect:/create_Schedule.html";


    }
}
