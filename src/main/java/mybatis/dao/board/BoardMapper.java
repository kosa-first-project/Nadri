package mybatis.dao.board;

import com.example.kosa_first_project.WebConfig.RequestList;
import com.example.kosa_first_project.domain.board.BoardDTO;
import com.example.kosa_first_project.domain.board.BoardFileDTO;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

@Mapper
public interface BoardMapper {

    // 게시글 전체 리스트 최신순으로 조회
    @Select("select id, user_id, title, content, rating, hits, date_format(createdAt, '%Y-%m-%d') as createdAt " +
            "from board order by id desc LIMIT #{pagination.limitStart}, #{recordSize}")
    List<BoardDTO> getBoardAll();

    // 게시글 상세 정보 조회 (id => PK)
    @Select("select id, user_id, title, content, rating, hits, date_format(createdAt, '%Y-%m-%d %H:%i:%s') as createdAt, fileAttached " +
            "from board where id = #{id}")
    BoardDTO getBoardOne(Long id);

    // 게시글 저장
    @Insert("insert into board(user_id, title, content, rating, fileAttached) " +
            "values ('dohun', #{title}, #{content}, #{rating}, #{fileAttached})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    void insertBoard(BoardDTO dto);

    // 게시글 수정
    @Update("update board set title = #{title}, content = #{content}, rating = #{rating} where id=#{id}")
    void updateBoard(BoardDTO dto);

    // 게시글 삭제
    @Delete("delete from board where id=#{id}")
    void deleteBoard(Long id);

    // 파일 저장
    @Insert("insert into board_file(originalFileName, storedFileName, board_id) " +
            "values( #{originalFileName}, #{storedFileName},#{board_id})")
    void insertFile(BoardFileDTO dto);

    // 파일 찾기
    @Select("select * from board_file where board_id = #{id}")
    List<BoardFileDTO> getFile(Long id);

    //게시판 수 계산
    @Select("select count(*) from board")
    Integer cntBoard();

    //조회 수 계산
    @Update("update board set hits = hits + 1 where id = #{id}")
    void updateHit(Long id);

    //게시글 검색
    @Select("SELECT * FROM board WHERE title LIKE CONCAT('%', #{keyword}, '%') " +
            "OR content LIKE CONCAT('%', #{keyword}, '%')")
    List<BoardDTO> searchBoardByKeyword(String keyword);


    //페이지네이션
    @Select({
            "<script>",
            "SELECT id, user_id, title, content, createdAt",
            "FROM BOARD",
            "<where>",
            "   <if test='requestList.data.title != null and requestList.data.title != \"\"'>",
            "       AND TITLE LIKE '%' || #{requestList.data.title} || '%'",
            "   </if>",
            "   <if test='requestList.data.user_id != null and requestList.data.user_id != \"\"'>",
            "       AND user_id LIKE '%' || #{requestList.data.user_id} || '%'",
            "   </if>",
            "</where>",
            "LIMIT #{requestList.pageable.pageSize} OFFSET #{requestList.pageable.offset}",
            "</script>"
    })
    List<Map<String, Object>> getListBoard(@Param("requestList") RequestList<?> requestList);


    @Select({
            "<script>",
            "SELECT COUNT(*) AS CNT",
            "FROM BOARD",
            "<where>",
            "   <if test='title != null and title != \"\"'>",
            "       AND title LIKE '%' || #{title} || '%'",
            "   </if>",
            "   <if test='user_id != null and user_id != \"\"'>",
            "       AND user_id LIKE '%' || #{user_id} || '%'",
            "   </if>",
            "</where>",
            "</script>"
    })
    int getListBoardCount(BoardDTO boardDTO);

}
