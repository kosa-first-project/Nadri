package mybatis.dao.login;

import com.example.kosa_first_project.domain.login.JoinUserDTO;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.transaction.annotation.Transactional;


@Mapper
@Transactional
public interface JoinMapper {
    //@Insert("insert into user(id,password, username , phone, gender, nickname, email, create_date, guide_activate) values (#{id}, #{password}, #{username}, #{phone}, #{gender}, #{nickname}, #{email}, #{create_date}, #{guide_activate})")
   // @Insert("INSERT INTO user(id, password, username, phone, gender, nickname, email, create_date, guide_activate) "
     //       + "VALUES (#{id}, #{password}, #{username}, #{phone}, #{gender}, #{nickname}, #{email}, "
       //     + "#{create_date}), #{guide_activate})")
    @Insert("INSERT INTO user (id, password, username, phone, gender, nickname, email, create_date, guide_activate) " +
            "VALUES (#{id}, #{password}, #{username}, #{phone}, #{gender}, #{nickname}, #{email}, NOW(), #{guide_activate})")
    public boolean save(JoinUserDTO joinUserDTO);
}
