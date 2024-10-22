package mybatis.dao.schedule;

import com.example.kosa_first_project.domain.schedule.ScheduleBlockDTO;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface ScheduleMapper {

    @Insert("INSERT INTO schedule (startDateTime, endDateTime, destination, comment, title, user_id) " +
            "VALUES (#{startDateTime}, #{endDateTime}, #{destination}, #{comment}, #{title}, #{user_id})")
    void saveScheduleBlock(ScheduleBlockDTO scheduleBlockDTO);

    // Get all schedule blocks for a logged in id
    @Select("SELECT DISTINCT title FROM schedule WHERE user_id = #{user_id}")
    List<String> getAllDistinctTitlesForUser(@Param("user_id") String user_id);

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