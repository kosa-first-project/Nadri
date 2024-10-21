package mybatis.dao.login;

import com.example.kosa_first_project.domain.login.UserDTO;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface UserMapper {
    //회원가입
    @Insert("INSERT INTO user (id, password, username, phone, gender, nickname, email, create_date, guide_activate) " +
            "VALUES (#{id}, #{password}, #{username}, #{phone}, #{gender}, #{nickname}, #{email}, NOW(), #{guide_activate})")
    public boolean save(UserDTO userDTO);

    //회원가입-아이디 중복확인
    @Select("SELECT count(*) from user where id = #{id}")
    public int findUserCount(String id);

    //로그인
    @Select("select * from user where id = #{id}")
    public UserDTO login(String id);
    
    //비밀번호 업데이트 전 유저 인증 페이지
    @Select("select count(*) from user where username = #{username} and email = #{email} and id = #{id}")
    public int findPassword(String username, String email, String id);

    //비밀번호 업데이트 페이지
    @Update("update user set password = #{password} where id= #{id}")
    public boolean updatePassword(String password, String id);

    //아이디 찾기 페이지
    @Select("select id from user where username = #{username} and email = #{email}")
    public String resultId(String username, String email);

}
