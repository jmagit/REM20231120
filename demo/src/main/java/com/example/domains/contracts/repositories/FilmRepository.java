package com.example.domains.contracts.repositories;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import com.example.domains.core.contracts.repositories.RepositoryWithProjections;
import com.example.domains.entities.Film;
import com.example.domains.entities.dtos.PeliShort;

@RepositoryRestResource(path="peliculas", itemResourceRel="pelicula", collectionResourceRel="peliculas")
public interface FilmRepository extends JpaRepository<Film, Integer> {
	@RestResource(path = "clasificacion")
	List<Film> findByRating(String tipo); 
}
