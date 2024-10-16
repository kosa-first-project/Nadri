package mybatis.dao.guide;

import com.example.kosa_first_project.domain.guide.GuideUnavailableTimeDTO;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface GuideUnavailableTimeMapper {

        @Insert("INSERT INTO guide_unavailable_time (guide_id, user_id, unavailable_start_date, unavailable_end_date) " +
                "VALUES (#{guideId}, #{userId}, #{unavailableStartDate}, #{unavailableEndDate})")
        void insertGuideUnavailableTime(GuideUnavailableTimeDTO unavailableTime);

        @Select("SELECT * FROM guide_unavailable_time WHERE id = #{id}")
        GuideUnavailableTimeDTO getGuideUnavailableTimeById(int id);

        @Select("SELECT * FROM guide_unavailable_time")
        List<GuideUnavailableTimeDTO> getAllGuideUnavailableTimes();

        @Update("UPDATE guide_unavailable_time SET guide_id = #{guideId}, user_id = #{userId}, " +
                "unavailable_start_date = #{unavailableStartDate}, unavailable_end_date = #{unavailableEndDate} " +
                "WHERE id = #{id}")
        void updateGuideUnavailableTime(GuideUnavailableTimeDTO unavailableTime);

        @Delete("DELETE FROM guide_unavailable_time WHERE id = #{id}")
        void deleteGuideUnavailableTime(int id);
}
