package com.furiousgamerz.web.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import com.furiousgamerz.web.dtos.DeveloperDto;
import com.furiousgamerz.web.models.Developer;

@Mapper(componentModel = "spring")
public interface DeveloperMapper {

	Developer devDtoToDev(DeveloperDto developerDto);

	List<Developer> devDtoToDev(List<DeveloperDto> developerDto);

	DeveloperDto devToDevDto(Developer developer);

	List<DeveloperDto> devToDevDto(List<Developer> developer);
}
