package com.devsuperior.dspesquisa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.devsuperior.dspesquisa.entity.Game;

@Repository
public interface GameRepository extends JpaRepository<Game, Long> {

}
