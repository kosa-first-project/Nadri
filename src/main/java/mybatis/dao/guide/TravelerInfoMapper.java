package mybatis.dao.guide;

import com.example.kosa_first_project.domain.guide.TravelerInfoDTO;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface TravelerInfoMapper {

        @Insert("INSERT INTO traveler_info (guide_info_id, user_id, start_date, end_date, phone, name, email, message, apply_time, traveler_info_state) " +
                "VALUES (#{guideInfoId}, #{userId}, #{startDate}, #{endDate}, #{phone}, #{name}, #{email}, #{message}, #{applyTime}, #{travelerInfoState})")
        void insertTravelerInfo(TravelerInfoDTO travelerInfo);

        @Select("SELECT " +
                "traveler_info_id AS travelerInfoId, " +
                "guide_info_id AS guideInfoId, " +
                "user_id AS userId, " +
                "start_date AS startDate, " +
                "end_date AS endDate, " +
                "phone AS phone, " +
                "name AS name, " +
                "email AS email, " +
                "message AS message, " +
                "apply_time AS applyTime, " +
                "traveler_info_state AS travelerInfoState " +
                "FROM traveler_info " +
                "WHERE traveler_info_id = #{travelerInfoId}")
        TravelerInfoDTO getTravelerInfoById(int travelerInfoId);

        @Select("SELECT " +
                "traveler_info_id AS travelerInfoId, " +
                "guide_info_id AS guideInfoId, " +
                "user_id AS userId, " +
                "start_date AS startDate, " +
                "end_date AS endDate, " +
                "phone AS phone, " +
                "name AS name, " +
                "email AS email, " +
                "message AS message, " +
                "apply_time AS applyTime, " +
                "traveler_info_state AS travelerInfoState " +
                "FROM traveler_info")
        List<TravelerInfoDTO> getAllTravelerInfo();

        @Update("UPDATE traveler_info SET " +
                "guide_info_id = #{guideInfoId}, " +
                "user_id = #{userId}, " +
                "start_date = #{startDate}, " +
                "end_date = #{endDate}, " +
                "phone = #{phone}, " +
                "name = #{name}, " +
                "email = #{email}, " +
                "message = #{message}, " +
                "apply_time = #{applyTime}, " +
                "traveler_info_state = #{travelerInfoState} " +
                "WHERE traveler_info_id = #{travelerInfoId}")
        void updateTravelerInfo(TravelerInfoDTO travelerInfo);

        @Delete("DELETE FROM traveler_info WHERE traveler_info_id = #{travelerInfoId}")
        void deleteTravelerInfo(int travelerInfoId);
}
