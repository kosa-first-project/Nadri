package mybatis.dao.login;

import com.example.kosa_first_project.domain.login.LoginUserDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface LoginMapper {
    @Select("select * from user where id = #{id} AND password = #{password}")
    public LoginUserDTO login(String id, String password);
}
