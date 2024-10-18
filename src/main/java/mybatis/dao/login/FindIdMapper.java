package mybatis.dao.login;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface FindIdMapper {
    @Select("select id from user where name = #{name} and email = #{email} and password = #{password} ")
    public String resultId(String name, String email, String password);
}
