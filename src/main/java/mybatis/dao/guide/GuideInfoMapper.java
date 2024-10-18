package mybatis.dao.guide;

import com.example.kosa_first_project.domain.guide.GuideInfoDTO;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface GuideInfoMapper {
        /*
        //전체 칼럼 Insert
        @Insert("INSERT INTO guide_info (" +
                "user_id, city, town, village, name, title, career, capacity, text, " +
                "weekday_price, weekend_price, board_rating, like_count, guide_info_state" +
                ") VALUES (" +
                "#{userId}, #{city}, #{town}, #{village}, #{name}, #{title}, #{career}, #{capacity}, #{text}, " +
                "#{weekdayPrice}, #{weekendPrice}, #{boardRating}, #{likeCount}, #{guideInfoState}" +
                ")")
        @Options(useGeneratedKeys = true, keyProperty = "guideInfoId")
        void insertGuideInfo(GuideInfoDTO guideInfo);
        */

        //실질적으로 사용하는 칼럼만 Insert
        @Insert("INSERT INTO guide_info (" +
                "user_id, city, name, title, career, capacity, text, " +
                "weekday_price, guide_info_state" +
                ") VALUES (" +
                "#{userId}, #{city}, #{name}, #{title}, #{career}, #{capacity}, #{text}, " +
                "#{weekdayPrice}, #{guideInfoState}" +
                ")")
        @Options(useGeneratedKeys = true, keyProperty = "guideInfoId")
        void insertGuideInfo(GuideInfoDTO guideInfo);




        @Select("SELECT " +
                "guide_info_id AS guideInfoId, " +
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
                "guide_info_state AS guideInfoState " +
                "FROM guide_info " +
                "WHERE guide_info_id = #{guideInfoId}")
        GuideInfoDTO getGuideInfoById(int guideInfoId);



        @Select("SELECT " +
                "guide_info_id AS guideInfoId, " +
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
                "guide_info_state AS guideInfoState " +
                "FROM guide_info")
        List<GuideInfoDTO> getAllGuideInfo();

        /*
        //전체 칼럼 Update
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
                "guide_info_state = #{guideInfoState} " +
                "WHERE guide_info_id = #{guideInfoId}")
        void updateGuideInfo(GuideInfoDTO guideInfo);
        */

        //실질적으로 사용하는 칼럼만 Update
        @Update("UPDATE guide_info SET " +
                "city = #{city}, " +
                "name = #{name}, " +
                "title = #{title}, " +
                "career = #{career}, " +
                "capacity = #{capacity}, " +
                "text = #{text}, " +
                "weekday_price = #{weekdayPrice}, " +
                "guide_info_state = #{guideInfoState} " +
                "WHERE guide_info_id = #{guideInfoId}")
        void updateGuideInfo(GuideInfoDTO guideInfo);

        @Delete("DELETE FROM guide_info WHERE guide_info_id = #{guideInfoId}")
        void deleteGuideInfo(int guideInfoId);
}
