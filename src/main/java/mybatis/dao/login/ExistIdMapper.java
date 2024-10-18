package mybatis.dao.login;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ExistIdMapper {
    @Insert("insert ignore into user (id) values (#{id})")
    public boolean checkId(String id);
}
