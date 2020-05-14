package com.furiousgamerz.web.mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.furiousgamerz.web.repositories.DeveloperRepository;

public abstract class DeveloperMapperDecorator implements DeveloperMapper {
	@Autowired
	@Qualifier("delegate")
	private DeveloperMapper delegate;

	@Autowired
	DeveloperRepository repository;

}
