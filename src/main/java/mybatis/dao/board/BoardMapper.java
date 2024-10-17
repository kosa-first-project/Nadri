package mybatis.dao.board;

import com.example.kosa_first_project.domain.board.BoardDTO;
import com.example.kosa_first_project.domain.board.FileDTO;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface BoardMapper {

    // 게시글 전체 리스트 조회
    @Select({
            "SELECT b.*",
            "     , CASE WHEN COUNT(*) > 1",
            "            THEN CONCAT(f.filename, '외 ' , COUNT(*)-1, '건')",
            "            ELSE f.filename",
            "        END AS file_name",
            "FROM board b",
            "LEFT JOIN file f ON b.id = f.board_id",
            "GROUP BY b.id",
            "ORDER BY b.id DESC",
            "LIMIT #{pageSize} OFFSET #{pageOffset}"
    })
    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "fileName", column = "fileName") // fileName을 결과로 매핑
    })
    List<BoardDTO> getBoardAll(BoardDTO dto);

    // 게시글 상세 정보 조회 (id => PK)
    @Select("select * from board where id = #{id}")
    BoardDTO getBoardOne(Long id);

    // 게시글 수정
    @Update("update board set title = #{title}, content = #{content}, rating = #{rating}, modify_date = #{now()} where id = #{id}")
    void updateBoard(BoardDTO dto);

    // 게시글 삭제
    @Delete("delete from board where id = #{id}")
    boolean deleteBoard(long id);

    // 게시글 저장
    @Insert("insert into board(user_id, title, content, image, rating, write_date, modify_date) " +
            "values (#{user_id}, #{title}, #{content}, #{image}, #{rating}, NOW(), Null)")
    @SelectKey(statement = "SELECT LAST_INSERT_ID()", keyProperty = "id", before = false, resultType = long.class)
    void insertBoard(BoardDTO dto);

    // 첨부파일 리스트
    @Select("select * from file where  board_id= #{id}")
    List<FileDTO> getFile(BoardDTO dto);

    //파일 삽입
    @Insert({
            "<script>",
            "INSERT INTO image (id, uuid, filename, content_type) VALUES ",
            "<foreach collection='list' item='item' separator=','>",
            "(#{id}, #{item.uuid}, #{item.filename}, #{item.contentType})",
            "</foreach>",
            "</script>"
    })
    void insertFile(BoardDTO dto);

    //파일 삭제
    @Update("UPDATE image WHERE id=#{id}")
    void deleteFile(BoardDTO dto);

    //조회 수 계산
    @Select("select count(*) from board")
    Integer cntBoard();
}
