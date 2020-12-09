package com.github.huifer.convert.mapstruct.smaple;

import com.github.huifer.convert.mapstruct.model.UserEntity;
import com.github.huifer.convert.mapstruct.model.UserTarget;
import com.github.huifer.convert.mapstruct.model.UserTarget2;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

/**
 *
 *
 * @author huifer
 */
@Mapper
public interface UserConvert {
    UserConvert INSTANCE = Mappers.getMapper(UserConvert.class);


    @Mappings(
            value = {
                    @Mapping(target = "username", source = "name")
            })
    UserTarget toTarget(UserEntity userEntity);

    @Mappings(
            value = {
                    @Mapping(target = "cnName", source = "name")
            })
    UserTarget2 toTarget2(UserEntity userEntity);

}
