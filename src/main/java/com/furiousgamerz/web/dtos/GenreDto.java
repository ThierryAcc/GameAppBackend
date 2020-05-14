package com.furiousgamerz.web.dtos;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Data
public class GenreDto {

    private Long id;

    @NotEmpty
    @Size(min = 5, max = 20)
    private String name;

}
