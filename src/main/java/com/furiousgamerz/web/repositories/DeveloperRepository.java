package com.furiousgamerz.web.repositories;

import com.furiousgamerz.web.models.Developer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DeveloperRepository extends JpaRepository<Developer, Long> {
}
