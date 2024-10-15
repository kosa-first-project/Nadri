package mybatis.dao.guide;


import com.example.kosa_first_project.domain.guide.GuideInfoDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface GuideMapper {

    public interface GuideInfoMapper {

        // Insert a new guide info
        void insertGuideInfo(GuideInfoDTO guideInfo);

        // Retrieve guide info by ID
        GuideInfoDTO getGuideInfoById(int id);

        // Retrieve all guide info entries
        List<GuideInfoDTO> getAllGuideInfo();

        // Update an existing guide info
        void updateGuideInfo(GuideInfoDTO guideInfo);

        // Delete a guide info by ID
        void deleteGuideInfo(int id);
    }




}
