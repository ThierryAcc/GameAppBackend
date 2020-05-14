package com.furiousgamerz.web.repositories;

import com.furiousgamerz.web.models.Game;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GameRepository extends JpaRepository<Game, Long> {
}
