package com.example.kosa_first_project.controller.schedule;

import com.example.kosa_first_project.domain.schedule.ScheduleBlockDTO;
import jakarta.servlet.http.HttpSession;
import mybatis.dao.schedule.ScheduleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

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

        // Retrieve the title from the session
        String title = (String) httpSession.getAttribute("scheduleTitle");

        String user_id = "user1";

        // Create a new schedule block
        ScheduleBlockDTO scheduleBlockDTO = new ScheduleBlockDTO(destination, startDateTime, endDateTime, comment, title, user_id);

        // Save the block to the database
        scheduleMapper.saveScheduleBlock(scheduleBlockDTO);

        // Redirect to schedule creation page
        return "redirect:/create_Schedule.html";
    }

    // insert data into show_Schedules page
    @GetMapping("/show_Schedules.html")
    public String showScheduleTitles(Model model) {
        // DB에서 사용자 ID에 맞는 제목들을 가져오기 (여기서는 "user1"을 사용)
        String userId = "user1";  // 실제로는 세션에서 가져올 수도 있음
        List<String> scheduleTitles = scheduleMapper.getAllDistinctTitlesForUser(userId);

        // 제목 리스트를 모델에 추가
        model.addAttribute("scheduleTitles", scheduleTitles);
        return "show_Schedules";
    }

    // move into schedule/selected_title page through the given data(title)
    @GetMapping("/schedule/show")
    public String showSelectedSchedule(@RequestParam(value = "title", required = true) String title, Model model) {
        String userId = "user1";  // 실제로는 세션에서 가져옴

        // 제목과 사용자 ID를 기준으로 날짜순으로 정렬된 스케줄 블럭을 가져옴
        List<ScheduleBlockDTO> scheduleBlocks = scheduleMapper.showScheduleByStartDateTime(title, userId);

        // 가져온 데이터가 없을 때 에러 메시지 출력
        if (scheduleBlocks == null || scheduleBlocks.isEmpty()) {
            model.addAttribute("errorMessage", "해당 제목에 대한 스케줄이 존재하지 않습니다.");
        } else {
            model.addAttribute("scheduleBlocks", scheduleBlocks);
            model.addAttribute("selectedTitle", title);
        }

        return "schedule/selected_title";
    }

    @GetMapping("/edit_Schedules.html")
    public String editScheduleTitles(Model model) {
        // DB에서 사용자 ID에 맞는 제목들을 가져오기 (여기서는 "user1"을 사용)
        String userId = "user1";  // 실제로는 세션에서 가져올 수도 있음
        List<String> scheduleTitles = scheduleMapper.getAllDistinctTitlesForUser(userId);

        // 제목 리스트를 모델에 추가
        model.addAttribute("scheduleTitles", scheduleTitles);
        return "redirect:/edit_Schedules";
    }

    @GetMapping("/schedule/edit")
    public String SelectedSchedule(@RequestParam(value = "title", required = true) String title, Model model) {
        String userId = "user1";  // 실제로는 세션에서 가져옴

        // 제목과 사용자 ID를 기준으로 날짜순으로 정렬된 스케줄 블럭을 가져옴
        List<ScheduleBlockDTO> scheduleBlocks = scheduleMapper.showScheduleByStartDateTime(title, userId);

        // 가져온 데이터가 없을 때 에러 메시지 출력
        if (scheduleBlocks == null || scheduleBlocks.isEmpty()) {
            model.addAttribute("errorMessage", "해당 제목에 대한 스케줄이 존재하지 않습니다.");
        } else {
            model.addAttribute("scheduleBlocks", scheduleBlocks);
            model.addAttribute("selectedTitle", title);
        }

        return "schedule/scheduleEditor";
    }
}
