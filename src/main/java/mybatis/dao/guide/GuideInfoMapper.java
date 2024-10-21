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
                "FROM guide_info " +
                "ORDER BY guide_info_id DESC")
                // guide_info_id 역순으로 정렬
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

        @Update("UPDATE guide_info SET " +
                "guide_info_state = #{guideInfoState} " +
                "WHERE guide_info_id = #{guideInfoId}")
        void updateGuideInfoState(GuideInfoDTO guideInfo);

        @Delete("DELETE FROM guide_info WHERE guide_info_id = #{guideInfoId}")
        void deleteGuideInfo(int guideInfoId);

        @Select("<script>" +
                "SELECT " +
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
                "WHERE 1=1 " +
                "<if test='city != null and city != \"all\"'> " +
                "AND city = #{city} " +
                "</if> " +
                "<if test='search != null and search != \"\"'> " +
                "AND (title LIKE CONCAT('%', #{search}, '%') OR text LIKE CONCAT('%', #{search}, '%')) " +
                "</if> " +
                "ORDER BY guide_info_id DESC" +
                "</script>")
        List<GuideInfoDTO> searchGuides(@Param("search") String search, @Param("city") String city);


}
