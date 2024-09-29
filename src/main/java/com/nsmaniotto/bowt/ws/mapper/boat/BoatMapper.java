package com.nsmaniotto.bowt.ws.mapper.boat;

import com.nsmaniotto.bowt.persistence.entity.boat.Boat;
import com.nsmaniotto.bowt.ws.dto.boat.BoatDto;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

@Mapper
public interface BoatMapper {

    /**
     * Default bean
     */
    @Named("boatToBoatDto")
    @BeanMapping(ignoreByDefault = true)
    BoatDto boatToBoatDto(Boat boat);

    /**
     * DTOs displayed in BoatPageContainer
     */
    @Named("toBoatListDto")
    @BeanMapping(ignoreByDefault = true)
    @Mapping(source = "name", target = "name")
    BoatDto toBoatListDto(Boat boat);

    /**
     * Others
     */
    @Named("toIdDto")
    @BeanMapping(ignoreByDefault = true)
    @Mapping(source = "id", target = "id")
    BoatDto toIdDto(Boat endpoint);

}
