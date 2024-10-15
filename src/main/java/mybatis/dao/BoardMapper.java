package mybatis.dao;

import com.example.kosa_first_project.domain.BoardDTO;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper // DB통신
public interface BoardMapper {

    // 회원 저장
    @Insert("insert into user(user_id) values (#{user_id}")
    public boolean userSave();

    // 게시글 저장
    @Insert("insert into board(user_id, title, context, image, rating, write_date, modify_date) " +
            "values (#{user.user_id}, #{title}, #{context}, #{image}, #{rating}, NOW(), Null)")
    @Options(useGeneratedKeys = true, keyProperty = "user") //
    public void boardSave(BoardDTO dto);

    // 게시글 상세 정보 조회 (id => PK)
    @Select("select * from board where id = #{id}")
    public BoardDTO findById(Long id);

    // 게시글 수정
    @Update("update board set title = #{title}, context = #{context}, rating = #{rating}, modify_date = #{now()} where id = #{id}")
    public void update(BoardDTO board);

    // 게시글 삭제
    @Delete("delete from board where id = #{id}")
    public boolean deleteById(String id);


    // 게시글 전체 리스트 조회
    @Select("select * from board order by id desc")
    public List<BoardDTO> findAll();

}
