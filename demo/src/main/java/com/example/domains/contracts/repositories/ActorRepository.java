package com.example.domains.contracts.repositories;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.example.domains.core.contracts.repositories.RepositoryWithProjections;
import com.example.domains.entities.Actor;
import com.example.domains.entities.dtos.ActorDTO;
import com.example.domains.entities.dtos.ActorShort;

@RepositoryRestResource(exported = false)
public interface ActorRepository extends JpaRepository<Actor, Integer>, JpaSpecificationExecutor<Actor>, 
	RepositoryWithProjections {
	List<Actor> findTop5ByFirstNameStartingWithOrderByLastNameDesc(String prefijo);
	List<Actor> findTop5ByFirstNameStartingWith(String prefijo, Sort orderBy);

	List<Actor> findByActorIdGreaterThanEqual(int id);
	@Query(value = "from Actor a where a.actorId >= ?1")
	List<Actor> findByNovedadesJPQL(int id);
	@Query(value = "select * from actor a where a.actor_id >= :id", nativeQuery = true)
	List<Actor> findByNovedadesSQL(int id);
	
	List<ActorDTO> readByActorIdGreaterThanEqual(int id);
	List<ActorShort> queryByActorIdGreaterThanEqual(int id);
	<T> List<T> searchByActorIdGreaterThanEqual(int id, Class<T> proyeccion);
}
