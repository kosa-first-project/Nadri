package mybatis.dao.login;

import com.example.kosa_first_project.domain.login.JoinUserDTO;
import com.example.kosa_first_project.domain.login.LoginUserDTO;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;


@Mapper
public interface JoinMapper {
    //@Insert("insert into user(id,password, username , phone, gender, nickname, email, create_date, guide_activate) values (#{id}, #{password}, #{username}, #{phone}, #{gender}, #{nickname}, #{email}, #{create_date}, #{guide_activate})")
   // @Insert("INSERT INTO user(id, password, username, phone, gender, nickname, email, create_date, guide_activate) "
     //       + "VALUES (#{id}, #{password}, #{username}, #{phone}, #{gender}, #{nickname}, #{email}, "
       //     + "#{create_date}), #{guide_activate})")
    @Insert("INSERT INTO user (id, password, username, phone, gender, nickname, email, create_date, guide_activate) " +
            "VALUES (#{id}, #{password}, #{username}, #{phone}, #{gender}, #{nickname}, #{email}, #{create_date}, #{guide_activate})")
    public boolean save(JoinUserDTO joinUserDTO);
}
