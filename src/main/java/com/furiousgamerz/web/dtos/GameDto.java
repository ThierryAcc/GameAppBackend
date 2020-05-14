package com.furiousgamerz.web.dtos;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Data
public class GameDto {

    private Long id;

    @NotEmpty
    @Size(min = 5, max = 150)
    private String title;

    BigDecimal suggestedPrice;

    List<GenreDto> genres = new ArrayList<>();
}
