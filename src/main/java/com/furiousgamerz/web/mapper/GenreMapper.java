package com.furiousgamerz.web.mapper;

import com.furiousgamerz.web.dtos.GenreDto;
import com.furiousgamerz.web.models.Genre;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface GenreMapper {

    GenreDto genreToGenreDto(Genre genre);
    List<GenreDto> genreToGenreDto(List<Genre> genre);
    Genre genreDtoToGenre(GenreDto genre);
    List<Genre> genreDtoToGenre(List<GenreDto> genre);
}
