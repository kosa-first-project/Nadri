package mybatis.dao.guide;


import com.example.kosa_first_project.domain.guide.GuideInfoDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface GuideMapper {

    public interface GuideInfoMapper {


        void insertGuideInfo(GuideInfoDTO guideInfo);


        GuideInfoDTO getGuideInfoById(int id);

        //@Select()
        List<GuideInfoDTO> getAllGuideInfo();


        void updateGuideInfo(GuideInfoDTO guideInfo);


        void deleteGuideInfo(int id);
    }




}
