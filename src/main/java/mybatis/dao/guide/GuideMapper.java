package mybatis.dao.guide;

import com.example.kosa_first_project.domain.guide.GuideInfoDTO;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface GuideMapper {

    public interface GuideInfoMapper {

        @Insert("INSERT INTO guide_info (" +
                "user_id, city, town, village, name, title, career, capacity, text, " +
                "weekday_price, weekend_price, board_rating, like_count, state" +
                ") VALUES (" +
                "#{user_id}, #{city}, #{town}, #{village}, #{name}, #{title}, #{career}, #{capacity}, #{text}, " +
                "#{weekdayPrice}, #{weekendPrice}, #{boardRating}, #{likeCount}, #{state}" +
                ")")
        void insertGuideInfo(GuideInfoDTO guideInfo);

        @Select("SELECT " +
                "id, " +
                "user_id AS userId, " +
                "city, " +
                "town, " +
                "village, " +
                "name, " +
                "title, " +
                "career, " +
                "capacity, " +
                "text, " +
                "weekday_price AS weekdayPrice, " +
                "weekend_price AS weekendPrice, " +
                "board_rating AS boardRating, " +
                "like_count AS likeCount, " +
                "state " +
                "FROM guide_info " +
                "WHERE id = #{id}")
        GuideInfoDTO getGuideInfoById(int id);

        @Select("SELECT " +
                "id, " +
                "user_id AS userId, " +
                "city, " +
                "town, " +
                "village, " +
                "name, " +
                "title, " +
                "career, " +
                "capacity, " +
                "text, " +
                "weekday_price AS weekdayPrice, " +
                "weekend_price AS weekendPrice, " +
                "board_rating AS boardRating, " +
                "like_count AS likeCount, " +
                "state " +
                "FROM guide_info")
        List<GuideInfoDTO> getAllGuideInfo();

        @Update("UPDATE guide_info SET " +
                "user_id = #{userId}, " +
                "city = #{city}, " +
                "town = #{town}, " +
                "village = #{village}, " +
                "name = #{name}, " +
                "title = #{title}, " +
                "career = #{career}, " +
                "capacity = #{capacity}, " +
                "text = #{text}, " +
                "weekday_price = #{weekdayPrice}, " +
                "weekend_price = #{weekendPrice}, " +
                "board_rating = #{boardRating}, " +
                "like_count = #{likeCount}, " +
                "state = #{state} " +
                "WHERE id = #{id}")
        void updateGuideInfo(GuideInfoDTO guideInfo);

        @Delete("DELETE FROM guide_info WHERE id = #{id}")
        void deleteGuideInfo(int id);
    }

}
