package com.furiousgamerz.web.dtos;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import lombok.Data;

@Data
public class DeveloperDto {

	private Long id;

	@NotEmpty
	@Size(min = 2, max = 50)
	private String name;

	Integer yearFounded;
}
