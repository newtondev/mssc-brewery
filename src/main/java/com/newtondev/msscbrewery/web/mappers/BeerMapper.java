package com.newtondev.msscbrewery.web.mappers;

import com.newtondev.msscbrewery.domain.Beer;
import com.newtondev.msscbrewery.web.model.BeerDto;
import org.mapstruct.Mapper;

@Mapper(uses = {DateMapper.class})
public interface BeerMapper {

    BeerDto beerToBeerDto(Beer beer);

    Beer beerDtoToBeer(BeerDto dto);

}
