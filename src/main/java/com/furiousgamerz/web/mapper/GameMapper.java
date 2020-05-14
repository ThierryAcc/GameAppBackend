package com.furiousgamerz.web.mapper;

import com.furiousgamerz.web.dtos.GameDto;
import com.furiousgamerz.web.models.Game;
import org.mapstruct.DecoratedWith;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
@DecoratedWith(GameMapperDecorator.class)
public interface GameMapper {

    GameDto gameToGameDto(Game game);
    List<GameDto> gameToGameDto(List<Game> game);
    Game gameDtoToGame(GameDto game);
    List<Game> gameDtoToGame(List<GameDto> game);

}
