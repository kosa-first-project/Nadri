package mybatis.dao.guide;

import com.example.kosa_first_project.domain.guide.TravelerApplyDTO;
import org.apache.ibatis.annotations.*;

import java.util.List;
@Mapper
public interface TravelerApplyMapper {

        @Insert("INSERT INTO traveler_apply (traveler_info_id, guide_info_id, apply_time, accept_time, cancel_time, done_time, traveler_apply_state) " +
                "VALUES (#{travelerInfoId}, #{guideInfoId}, #{applyTime}, #{acceptTime}, #{cancelTime}, #{doneTime}, #{travelerApplyState})")
        void insertTravelerApply(TravelerApplyDTO apply);

        @Select("SELECT " +
                "traveler_apply_id AS travelerApplyId, " +
                "traveler_info_id AS travelerInfoId, " +
                "guide_info_id AS guideInfoId, " +
                "apply_time AS applyTime, " +
                "accept_time AS acceptTime, " +
                "cancel_time AS cancelTime, " +
                "done_time AS doneTime, " +
                "traveler_apply_state AS travelerApplyState " +
                "FROM traveler_apply " +
                "WHERE traveler_apply_id = #{travelerApplyId}")
        TravelerApplyDTO getTravelerApplyById(int travelerApplyId);

        @Select("SELECT " +
                "traveler_apply_id AS travelerApplyId, " +
                "traveler_info_id AS travelerInfoId, " +
                "guide_info_id AS guideInfoId, " +
                "apply_time AS applyTime, " +
                "accept_time AS acceptTime, " +
                "cancel_time AS cancelTime, " +
                "done_time AS doneTime, " +
                "traveler_apply_state AS travelerApplyState " +
                "FROM traveler_apply")
        List<TravelerApplyDTO> getAllTravelerApplies();

        @Update("UPDATE traveler_apply SET traveler_info_id = #{travelerInfoId}, guide_info_id = #{guideInfoId}, " +
                "apply_time = #{applyTime}, accept_time = #{acceptTime}, cancel_time = #{cancelTime}, " +
                "done_time = #{doneTime}, traveler_apply_state = #{travelerApplyState} " +
                "WHERE traveler_apply_id = #{travelerApplyId}")
        void updateTravelerApply(TravelerApplyDTO apply);

        @Delete("DELETE FROM traveler_apply WHERE traveler_apply_id = #{travelerApplyId}")
        void deleteTravelerApply(int travelerApplyId);
}
