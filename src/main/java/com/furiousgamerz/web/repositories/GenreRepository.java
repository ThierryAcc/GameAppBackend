package com.furiousgamerz.web.repositories;

import com.furiousgamerz.web.models.Genre;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GenreRepository extends JpaRepository<Genre, Long> {

    Genre findByName(String name);
}
