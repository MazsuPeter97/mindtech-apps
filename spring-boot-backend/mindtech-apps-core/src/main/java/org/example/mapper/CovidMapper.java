package org.example.mapper;

import org.example.dto.CovidDTO;
import org.example.entity.Covid;
import org.mapstruct.MapMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CovidMapper {

    CovidMapper INSTANCE = Mappers.getMapper(CovidMapper.class);

    CovidDTO covidToCovidDto(Covid covid);

    Covid covidDtoToCovid(CovidDTO covidDTO);

    List<Covid> covidDtoListToCovidList(List<CovidDTO> covidDTOS);

    List<CovidDTO> covidListToCovidDtoList(List<Covid> covids);
}
