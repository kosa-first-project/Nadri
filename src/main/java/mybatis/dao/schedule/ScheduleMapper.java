package mybatis.dao.schedule;

import com.example.kosa_first_project.domain.schedule.ScheduleDateDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Insert;

@Mapper
public interface ScheduleMapper {

    @Insert("INSERT INTO one_schedule (total_schedule_id, user_id, spot_name, start_date_time, end_date_time) VALUES (1, 1, #{destination}, #{startDateTime}, #{endDateTime})")
    void saveSchedule(ScheduleDateDTO scheduleDateDTO);
    // Other mapper methods can be added here
}
