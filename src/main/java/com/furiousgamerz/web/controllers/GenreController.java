package com.furiousgamerz.web.controllers;

import com.furiousgamerz.web.dtos.GenreDto;
import com.furiousgamerz.web.mapper.GenreMapper;
import com.furiousgamerz.web.models.Genre;
import com.furiousgamerz.web.repositories.GenreRepository;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class GenreController {

    final GenreMapper genreMapper;
    final GenreRepository genreRepository;

    public GenreController(GenreMapper genreMapper, GenreRepository genreRepository) {
        this.genreMapper = genreMapper;
        this.genreRepository = genreRepository;
    }

    @PostMapping("/genres")
    public GenreDto createGenre(@RequestBody @Validated GenreDto genreDto) {
        Genre genre = genreMapper.genreDtoToGenre(genreDto);
        genreRepository.save(genre);
        return genreMapper.genreToGenreDto(genre);
    }

    @GetMapping("/genres")
    public List<GenreDto> findAll() {
        return genreMapper.genreToGenreDto(genreRepository.findAll());
    }

    @GetMapping("/genres/{id}")
    public GenreDto findOne(@PathVariable("id") Long id) {
        return genreMapper.genreToGenreDto(genreRepository.findById(id).get());
    }
}
