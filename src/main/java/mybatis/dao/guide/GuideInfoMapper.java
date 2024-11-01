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


/*
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
                "WHERE guide_info_state != 'delete' " + //삭제상태가 아닌 것
                "ORDER BY guide_info_id DESC")
                // guide_info_id 역순으로 정렬
        List<GuideInfoDTO> getAllGuideInfo();
*/
        @Select("SELECT " +
        "gi.guide_info_id AS guideInfoId, " +
        "gi.user_id AS userId, " +
        "u.nickname AS nickname, " + // 닉네임 추가
        "gi.city, " +
        "gi.town, " +
        "gi.village, " +
        "gi.name, " +
        "gi.title, " +
        "gi.career, " +
        "gi.capacity, " +
        "gi.text, " +
        "gi.weekday_price AS weekdayPrice, " +
        "gi.weekend_price AS weekendPrice, " +
        "gi.board_rating AS boardRating, " +
        "gi.like_count AS likeCount, " +
        "gi.guide_info_state AS guideInfoState " +
        "FROM guide_info gi " +
        "JOIN user u ON gi.user_id = u.id " + // user 테이블과 조인
        "WHERE gi.guide_info_id = #{guideInfoId}")
GuideInfoDTO getGuideInfoById(int guideInfoId);

        @Select("SELECT " +
                "gi.guide_info_id AS guideInfoId, " +
                "gi.user_id AS userId, " +
                "u.nickname AS nickname, " + // 닉네임 추가
                "gi.city, " +
                "gi.town, " +
                "gi.village, " +
                "gi.name, " +
                "gi.title, " +
                "gi.career, " +
                "gi.capacity, " +
                "gi.text, " +
                "gi.weekday_price AS weekdayPrice, " +
                "gi.weekend_price AS weekendPrice, " +
                "gi.board_rating AS boardRating, " +
                "gi.like_count AS likeCount, " +
                "gi.guide_info_state AS guideInfoState " +
                "FROM guide_info gi " +
                "JOIN user u ON gi.user_id = u.id " + // user 테이블과 조인
                "WHERE gi.guide_info_state = 'activate' " + // 활성화 상태인 것
                "ORDER BY gi.guide_info_id DESC")
        List<GuideInfoDTO> getAllGuideInfo();

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
                "WHERE guide_info_state != 'delete' " + //삭제상태가 아닌 것
                "AND user_id = #{userId} " + // userId가 특정 값과 일치하는 경우
                "ORDER BY guide_info_id DESC")
        List<GuideInfoDTO> getMyGuideInfo(String userId);

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
                "weekday_price = #{weekdayPrice} " +
                //"guide_info_state = #{guideInfoState}, " + //사용시 , 주의
                "WHERE guide_info_id = #{guideInfoId}")
        void updateGuideInfo(GuideInfoDTO guideInfo);

        @Update("UPDATE guide_info SET " +
                "guide_info_state = #{guideInfoState} " +
                "WHERE guide_info_id = #{guideInfoId}")
        void updateGuideInfoState(GuideInfoDTO guideInfo);

        @Delete("DELETE FROM guide_info WHERE guide_info_id = #{guideInfoId}")
        void deleteGuideInfo(int guideInfoId);
/*
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
        List<GuideInfoDTO> searchGuides(@Param("search") String search, @Param("city") String city);*/
/*

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
                //"AND guide_info_state != 'delete' " + //삭제상태가 아닌 것. 없어도 아래에서 해당 state만 조회가능
                "<if test='city != null and city != \"all\"'> " +
                "AND city = #{city} " +
                "</if> " +
                "<if test='search != null and search != \"\"'> " +
                "AND (title LIKE CONCAT('%', #{search}, '%') OR text LIKE CONCAT('%', #{search}, '%')) " +
                "</if> " +
                "<if test='status != null and status != \"all\"'> " +
                "AND guide_info_state = #{status} " +
                "</if> " +
                "ORDER BY guide_info_id DESC" +
                "</script>")
        List<GuideInfoDTO> searchGuides(@Param("search") String search, @Param("city") String city, @Param("status") String status);
*/
@Select("<script>" +
        "SELECT " +
        "gi.guide_info_id AS guideInfoId, " +
        "gi.user_id AS userId, " +
        "u.nickname AS nickname, " + // 닉네임 추가
        "gi.city, " +
        "gi.town, " +
        "gi.village, " +
        "gi.name, " +
        "gi.title, " +
        "gi.career, " +
        "gi.capacity, " +
        "gi.text, " +
        "gi.weekday_price AS weekdayPrice, " +
        "gi.weekend_price AS weekendPrice, " +
        "gi.board_rating AS boardRating, " +
        "gi.like_count AS likeCount, " +
        "gi.guide_info_state AS guideInfoState " +
        "FROM guide_info gi " +
        "JOIN user u ON gi.user_id = u.id " + // user 테이블과 조인
        "WHERE 1=1 " +
        "<if test='city != null and city != \"all\"'> " +
        "AND gi.city = #{city} " +
        "</if> " +
        "<if test='search != null and search != \"\"'> " +
        "AND (gi.title LIKE CONCAT('%', #{search}, '%') OR gi.text LIKE CONCAT('%', #{search}, '%')) " +
        "</if> " +
        "<if test='status != null and status != \"all\"'> " +
        "AND gi.guide_info_state = #{status} " +
        "</if> " +
        "ORDER BY gi.guide_info_id DESC" +
        "</script>")
List<GuideInfoDTO> searchGuides(@Param("search") String search, @Param("city") String city, @Param("status") String status);


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
                //"AND guide_info_state != 'delete' " + //삭제상태가 아닌 것. 없어도 아래에서 해당 state만 조회가능
                "<if test='city != null and city != \"all\"'> " +
                "AND city = #{city} " +
                "</if> " +
                "<if test='search != null and search != \"\"'> " +
                "AND (title LIKE CONCAT('%', #{search}, '%') OR text LIKE CONCAT('%', #{search}, '%')) " +
                "</if> " +
                "<if test='status != null and status != \"all\"'> " +
                "AND guide_info_state = #{status} " +
                "</if> " +
                "<if test='userId != null'> " +
                "AND user_id = #{userId} " +
                "</if> " +
                "ORDER BY guide_info_id DESC" +
                "</script>")
        List<GuideInfoDTO> searchMyGuides(@Param("search") String search,
                                          @Param("city") String city,
                                          @Param("status") String status,
                                          @Param("userId") String userId); // userId 추가/ /나의 가이드 활동 목록을 볼 때

}
