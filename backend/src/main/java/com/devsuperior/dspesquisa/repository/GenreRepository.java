package com.devsuperior.dspesquisa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.devsuperior.dspesquisa.entity.Genre;

@Repository
public interface GenreRepository extends JpaRepository<Genre, Long> {

}
