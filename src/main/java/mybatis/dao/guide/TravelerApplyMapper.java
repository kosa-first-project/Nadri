package mybatis.dao.guide;

import com.example.kosa_first_project.domain.guide.TravelerApplyDTO;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface TravelerApplyMapper {

        @Insert("INSERT INTO traveler_apply (traveler_id, guide_id, apply_time, accept_time, cancel_time, done_time, state) " +
                "VALUES (#{travelerId}, #{guideId}, #{applyTime}, #{acceptTime}, #{cancelTime}, #{doneTime}, #{state})")
        void insertTravelerApply(TravelerApplyDTO apply);

        @Select("SELECT " +
                "id AS travelerApplyId, " +
                "traveler_id AS travelerId, " +
                "guide_id AS guideId, " +
                "apply_time AS applyTime, " +
                "accept_time AS acceptTime, " +
                "cancel_time AS cancelTime, " +
                "done_time AS doneTime, " +
                "state AS state " +
                "FROM traveler_apply " +
                "WHERE id = #{id}")
        TravelerApplyDTO getTravelerApplyById(int id);


        @Select("SELECT " +
                "id AS travelerApplyId, " +
                "traveler_id AS travelerId, " +
                "guide_id AS guideId, " +
                "apply_time AS applyTime, " +
                "accept_time AS acceptTime, " +
                "cancel_time AS cancelTime, " +
                "done_time AS doneTime, " +
                "state AS state " +
                "FROM traveler_apply")
        List<TravelerApplyDTO> getAllTravelerApplies();


        @Update("UPDATE traveler_apply SET traveler_id = #{travelerId}, guide_id = #{guideId}, " +
                "apply_time = #{applyTime}, accept_time = #{acceptTime}, cancel_time = #{cancelTime}, " +
                "done_time = #{doneTime}, state = #{state} WHERE id = #{id}")
        void updateTravelerApply(TravelerApplyDTO apply);

        @Delete("DELETE FROM traveler_apply WHERE id = #{id}")
        void deleteTravelerApply(int id);
}
