package liga.medical.personservice.core.repository;

import liga.medical.personservice.core.model.IllnessEntity;
import org.apache.ibatis.annotations.*;
import java.util.List;

@Mapper
public interface IllnessRepository {

    @Select("select * from illness where id = #{illnessId}")
    IllnessEntity findById(Long illnessId);

    @Insert("insert into illness (medical_card_id, type_id, hearviness, appearance_dttm, recovery_dt) " +
            "values(#{medicalCardId}, #{typeId}, #{hearviness}, #{appearanceDttm}, #{recoveryDt})")
    @Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id")
    int insert(IllnessEntity illnessEntity);

    List<IllnessEntity> findByIds(@Param("illnessIds") List<Long> illnessIds);

    int insertAll(@Param("illnessList") List<IllnessEntity> illnessEntityList);

    Boolean updateById(@Param("illnessEntity") IllnessEntity illnessEntity);

    Boolean deleteById(@Param("illnessId") Long illnessId);
}
