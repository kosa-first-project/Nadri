package mybatis.dao.board;

import com.example.kosa_first_project.domain.board.BoardDTO;
import com.example.kosa_first_project.domain.board.FileDTO;
import org.apache.ibatis.annotations.*;


import java.util.List;

@Mapper
public interface BoardMapper {

    // 게시글 전체 리스트 조회
    @Select({
            "SELECT b.*, ",
            "CASE WHEN COUNT(*) > 1 ",
            "THEN CONCAT(f.filename, '외 ', COUNT(*) - 1, '건') ",
            "ELSE f.filename ",
            "END AS file_name ",
            "FROM board b ",
            "LEFT JOIN file f ON b.id = f.board_id ",
            "WHERE b.delete_yn != 1",
            "GROUP BY b.id ",
            "ORDER BY b.id DESC ",
            "LIMIT #{pageSize} OFFSET #{pageOffset}"
    })
    List<BoardDTO> getBoardAll(BoardDTO dto);

    // 게시글 상세 정보 조회 (id => PK)
    @Select("select * from board where delete_yn != 1 and id = #{id}")
    BoardDTO getBoardOne(Integer id);

    // 게시글 수정
    @Update("update board set title = #{title}, content = #{content}, rating = #{rating}, modify_date = #{now()}, hit = #{hit} where id = #{id}")
    void updateBoard(BoardDTO dto);

    // 게시글 삭제
    @Update("update board set delete_yn = 1 where id = #{id}")
    boolean deleteBoard(Integer id);

    // 게시글 저장
    @Insert("insert into board(user_id, title, content, rating, write_date, modify_date, hit) " +
            "values ('dohun', #{title}, #{content}, #{rating}, NOW(), Null, 0)")
    @SelectKey(statement = "SELECT LAST_INSERT_ID()", keyProperty = "id", before = false, resultType = long.class)
    void insertBoard(BoardDTO dto);

    // 첨부파일 리스트
    @Select("select * from file where delete_yn != 1 and board_id= #{id}")
    List<FileDTO> getFile(BoardDTO dto);

    //파일 삽입
    @Insert({
            "<script>",
            "INSERT INTO file (id, uuid, filename, content_type) VALUES ",
            "<foreach collection='list' item='item' separator=','>",
            "(#{id}, #{item.uuid}, #{item.filename}, #{item.contentType})",
            "</foreach>",
            "</script>"
    })
    void insertFile(BoardDTO dto);

    //파일 삭제
    @Update("UPDATE file set delete_yn = 1 where board.id=#{dto.id} and delete_yn = 0")
    void deleteFile(BoardDTO dto);

    //게시판 수 계산
    @Select("select count(*) from board where delete_yn != 1")
    Integer cntBoard();

    //조회 수 계산
    @Update("update board set hit = hit + 1 where id = #{id}")
    int updateHit(Integer id);
}
