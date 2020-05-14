package com.furiousgamerz.web.mapper;

import com.furiousgamerz.web.dtos.GameDto;
import com.furiousgamerz.web.dtos.GenreDto;
import com.furiousgamerz.web.models.Game;
import com.furiousgamerz.web.models.Genre;
import com.furiousgamerz.web.repositories.GenreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

public abstract class GameMapperDecorator implements GameMapper {
    @Autowired
    @Qualifier("delegate")
    private GameMapper delegate;

    @Autowired
    GenreRepository repository;

    /**
     * Maps a DTO to a Game.
     *
     * @param gameDto
     * @return
     */
    @Override
    public Game gameDtoToGame(GameDto gameDto) {
        if ( gameDto == null ) {
            return null;
        }

        Game persistentGame = new Game();
        persistentGame.setId( gameDto.getId() );
        persistentGame.setTitle( gameDto.getTitle() );
        persistentGame.setSuggestedPrice( gameDto.getSuggestedPrice() );

        Set<Genre> genreList = findOrCreateGenres(gameDto);
        persistentGame.setGenres(genreList);
        return persistentGame;
    }

    /**
     *      * checks if a genre has an ID,
     *      * and if so, it uses that ID to select the genre from the database.
     *      * If there is no ID, we search for a name. If there is no Genre
     *      * found, we create a new genre.
     * @param gameDto
     * @return
     */
    private Set<Genre> findOrCreateGenres(GameDto gameDto) {
        Set<Genre> genreList = new HashSet<>();
        gameDto.getGenres().forEach(genre -> {
            Long id = genre.getId();
            if (id != null) {
                findById(genreList, id);
            } else {
                findByNameOrCreateNew(genreList, genre);
            }
        });
        return genreList;
    }

    private void findByNameOrCreateNew(Set<Genre> genreList, GenreDto genre) {
        Genre byName = repository.findByName(genre.getName());
        if (byName != null) {
            genreList.add(byName);
        } else {
            Genre newGenre = new Genre();
            newGenre.setName(genre.getName());
            genreList.add(newGenre);
        }
    }

    private void findById(Set<Genre> genreList, Long id) {
        Optional<Genre> persistentGenre = repository.findById(id);
        if (persistentGenre.isPresent()) {
            genreList.add(persistentGenre.get());
        }
    }
}
