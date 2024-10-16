package mybatis.dao.guide;

import com.example.kosa_first_project.domain.guide.TravelerInfoDTO;
import org.apache.ibatis.annotations.*;

        import java.util.List;

@Mapper
public interface TravelerInfoMapper {

        @Insert("INSERT INTO traveler_info (user_id, name, email, city, preferences) " +
                "VALUES (#{userId}, #{name}, #{email}, #{city}, #{preferences})")
        void insertTravelerInfo(TravelerInfoDTO travelerInfo);

        @Select("SELECT " +
                "id AS travelerInfoId, " +
                "guide_id AS guideId, " +
                "user_id AS userId, " +
                "start_date AS startDate, " +
                "end_date AS endDate, " +
                "phone AS phone, " +
                "name AS name, " +
                "email AS email, " +
                "message AS message, " +
                "apply_time AS applyTime, " +
                "state AS state " +
                "FROM traveler_info " +
                "WHERE id = #{id}")
        TravelerInfoDTO getTravelerInfoById(int id);

        @Select("SELECT " +
                "id AS travelerInfoId, " +
                "guide_id AS guideId, " +
                "user_id AS userId, " +
                "start_date AS startDate, " +
                "end_date AS endDate, " +
                "phone AS phone, " +
                "name AS name, " +
                "email AS email, " +
                "message AS message, " +
                "apply_time AS applyTime, " +
                "state AS state " +
                "FROM traveler_info")
        List<TravelerInfoDTO> getAllTravelerInfo();


        @Update("UPDATE traveler_info SET user_id = #{userId}, name = #{name}, email = #{email}, " +
                "city = #{city}, preferences = #{preferences} WHERE id = #{id}")
        void updateTravelerInfo(TravelerInfoDTO travelerInfo);

        @Delete("DELETE FROM traveler_info WHERE id = #{id}")
        void deleteTravelerInfo(int id);
}

