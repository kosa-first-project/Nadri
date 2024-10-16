/*
package mybatis.dao.board;

import com.example.kosa_first_project.domain.board.BoardDTO;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper // DB통신
public interface BoardMapper {

    // 게시글 전체 리스트 조회
    @Select("select * from board order by id desc")
    public List<BoardDTO> getBoardList(BoardDTO boardDTO);

    // 게시글 상세 정보 조회 (id => PK)
    @Select("select * from board where id = #{id}")
    public BoardDTO getBoard(Long id);

    // 게시글 수정
    @Update("update board set title = #{title}, content = #{content}, rating = #{rating}, modify_date = #{now()} where id = #{id}")
    public void update(BoardDTO board);

    // 게시글 삭제
    @Delete("delete from board where id = #{id}")
    public boolean deleteBoard(long id);

    // 회원 조회
    @Select("select id from user where id = #{id}")
    public String findUserId(String id);

    // 게시글 저장
    @Insert("insert into board(user_id, title, content, image, rating, write_date, modify_date) " +
            "values (#{user_id}, #{title}, #{content}, #{image}, #{rating}, NOW(), Null)")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    public boolean boardSave(BoardDTO dto);

}
*/
