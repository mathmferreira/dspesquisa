package com.devsuperior.dspesquisa.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.devsuperior.dspesquisa.dto.GameDTO;
import com.devsuperior.dspesquisa.entity.Game;
import com.devsuperior.dspesquisa.repository.GameRepository;

@Service
@Transactional(propagation = Propagation.REQUIRED)
public class GameService {
	
	@Autowired
	private GameRepository repository;
	
	@Transactional(readOnly = true)
	public List<GameDTO> findAll() {
		List<Game> games = repository.findAll();
		return games.stream().map(GameDTO::new).collect(Collectors.toList());
	}

}
