package com.furiousgamerz.web.controllers;

import java.util.List;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.furiousgamerz.web.dtos.DeveloperDto;
import com.furiousgamerz.web.mapper.DeveloperMapper;
import com.furiousgamerz.web.models.Developer;
import com.furiousgamerz.web.repositories.DeveloperRepository;

@RestController
public class DeveloperController {

	final DeveloperRepository developerRepository;
	final DeveloperMapper developerMapper;

	public DeveloperController(DeveloperRepository developerRepository, DeveloperMapper developerMapper) {
		this.developerRepository = developerRepository;
		this.developerMapper = developerMapper;
	}

	@PostMapping("/developers")
	public DeveloperDto createGenre(@RequestBody @Validated DeveloperDto developerDto) {
		Developer developer = developerMapper.devDtoToDev(developerDto);
		developerRepository.save(developer);
		return developerMapper.devToDevDto(developer);
	}

	@GetMapping("/developers")
	public List<DeveloperDto> findAll() {
		return developerMapper.devToDevDto(developerRepository.findAll());
	}

	@GetMapping("/developers/{id}")
	public DeveloperDto findOne(@PathVariable("id") Long id) {
		return developerMapper.devToDevDto(developerRepository.findById(id).get());
	}
}
