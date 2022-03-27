package liga.medical.personservice.core.repository;

import liga.medical.personservice.core.model.AddressEntity;
import org.apache.ibatis.annotations.*;
import java.util.List;

@Mapper
public interface AddressRepository {

    @Select("select * from address where id = #{addressId}")
    AddressEntity findById(Long addressId);

    @Insert("insert into address (contact_id, country_id, city, index, street, building, flat) " +
            "values(#{contactId}, #{countryId}, #{city}, #{index}, #{street}, #{building}, #{flat})")
    @Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id")
    int insert(AddressEntity addressEntity);

    List<AddressEntity> findByIds(@Param("addressIds") List<Long> addressIds);

    int insertAll(@Param("addressList") List<AddressEntity> addressEntityList);

    Boolean updateById(@Param("addressEntity") AddressEntity addressEntity);

    Boolean deleteById(@Param("addressId") Long addressId);
}