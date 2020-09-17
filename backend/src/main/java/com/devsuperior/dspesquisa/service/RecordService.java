package com.devsuperior.dspesquisa.service;

import java.time.Instant;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.devsuperior.dspesquisa.dto.RecordDTO;
import com.devsuperior.dspesquisa.dto.RecordInsertDTO;
import com.devsuperior.dspesquisa.entity.Game;
import com.devsuperior.dspesquisa.entity.Record;
import com.devsuperior.dspesquisa.repository.GameRepository;
import com.devsuperior.dspesquisa.repository.RecordRepository;

@Service
@Transactional(propagation = Propagation.REQUIRED)
public class RecordService {
	
	@Autowired
	private RecordRepository repository;
	
	@Autowired
	private GameRepository gameRepository;
	
	public RecordDTO insert(RecordInsertDTO dto) {
		Record entity = new Record();
		entity.setName(dto.getName());
		entity.setAge(dto.getAge());
		entity.setMoment(Instant.now());
		
		Game game = gameRepository.getOne(dto.getIdGame());
		entity.setGame(game);
		
		entity = repository.save(entity);
		return new RecordDTO(entity);
	}
	
}
