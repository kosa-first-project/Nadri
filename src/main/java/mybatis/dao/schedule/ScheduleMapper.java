package mybatis.dao.schedule;

import com.example.kosa_first_project.domain.schedule.ScheduleBlockDTO;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface ScheduleMapper {

//    @Insert("INSERT INTO one_schedule (total_schedule_id, user_id, spot_name, start_date_time, end_date_time, comment, title) " +
//            "VALUES (1, #{user_id}, #{destination}, #{startDateTime}, #{endDateTime}, #{description}, #{title})")
//    void saveScheduleBlock(ScheduleBlockDTO scheduleBlockDTO);

    @Insert("INSERT INTO schedule (startDateTime, endDateTime, destination, comment, title, user_id) " +
            "VALUES (#{startDateTime}, #{endDateTime}, #{destination}, #{comment}, #{title}, 'user1')")
    void saveScheduleBlock(ScheduleBlockDTO scheduleBlockDTO);

    // Get all schedule blocks for a logged in id
    @Select("SELECT DISTINCT title FROM schedule WHERE user_id = #{userId}")
    List<String> getAllDistinctTitlesForUser(@Param("userId") String userId);

    // Get a specific schedule block through unique ID number
    @Select("SELECT * FROM schedule WHERE id = #{id}")
    ScheduleBlockDTO getScheduleBlockById(@Param("id") int id);

    // 스케줄 블럭 수정하기
    @Update("UPDATE schedule SET destination = #{destination}, startDateTime = #{startDateTime}, endDateTime = #{endDateTime}, comment = #{comment} WHERE id = #{id}")
    void updateScheduleBlock(ScheduleBlockDTO scheduleBlock);

    // get all information from specific title ehich client chose
    @Select("SELECT * FROM schedule WHERE title = #{title} AND user_id = #{userId} ORDER BY startDateTime")
    List<ScheduleBlockDTO> showScheduleByStartDateTime(@Param("title") String title, @Param("userId") String userId);

}