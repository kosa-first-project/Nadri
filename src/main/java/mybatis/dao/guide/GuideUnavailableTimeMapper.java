package mybatis.dao.guide;

import com.example.kosa_first_project.domain.guide.GuideUnavailableTimeDTO;
import org.apache.ibatis.annotations.*;

import java.util.List;
@Mapper
public interface GuideUnavailableTimeMapper {
        //전체 칼럼
        @Insert("INSERT INTO guide_unavailable_time (guide_id, user_id, unavailable_start_date, unavailable_end_date) " +
                "VALUES (#{guideId}, #{userId}, #{unavailableStartDate}, #{unavailableEndDate})")
        void insertGuideUnavailableTime(GuideUnavailableTimeDTO unavailableTime);

        //userid 칼럼 제외
        @Insert("INSERT INTO guide_unavailable_time (guide_id, user_id, unavailable_start_date, unavailable_end_date) " +
                "VALUES (#{guideId}, #{userId}, #{unavailableStartDate}, #{unavailableEndDate})")
        void insertGuideUnavailableTimeNoUserId(GuideUnavailableTimeDTO unavailableTime);


        @Select("SELECT " +
                "guide_unavailable_time_id AS guideUnavailableTimeId, " +
                "guide_info_id AS guideInfoId, " +
                "user_id AS userId, " +
                "unavailable_start_date AS unavailableStartDate, " +
                "unavailable_end_date AS unavailableEndDate " +
                "FROM guide_unavailable_time " +
                "WHERE guide_unavailable_time_id = #{guideUnavailableTimeId}") // 여기 확인
        GuideUnavailableTimeDTO getGuideUnavailableTimeById(int guideUnavailableTimeId); // 매개변수 이름도 일치시킴

        @Select("SELECT " +
                "guide_unavailable_time_id AS guideUnavailableTimeId, " +
                "guide_info_id AS guideInfoId, " +
                "user_id AS userId, " +
                "unavailable_start_date AS unavailableStartDate, " +
                "unavailable_end_date AS unavailableEndDate " +
                "FROM guide_unavailable_time")
        List<GuideUnavailableTimeDTO> getAllGuideUnavailableTimes();

        @Update("UPDATE guide_unavailable_time SET guide_info_id = #{guideInfoId}, user_id = #{userId}, " +
                "unavailable_start_date = #{unavailableStartDate}, unavailable_end_date = #{unavailableEndDate} " +
                "WHERE guide_unavailable_time_id = #{guideUnavailableTimeId}")
        void updateGuideUnavailableTime(GuideUnavailableTimeDTO unavailableTime);

        @Delete("DELETE FROM guide_unavailable_time WHERE guide_unavailable_time_id = #{guideUnavailableTimeId}")
        void deleteGuideUnavailableTime(int guideUnavailableTimeId); // 매개변수 이름 일치
}
