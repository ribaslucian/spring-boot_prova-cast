package br.com.baseapp.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.baseapp.domains.Hero;

public interface HeroesRepository extends JpaRepository<Hero, UUID> {
// public interface HeroesRepository extends CrudRepository<Hero, Long> {
    
}
