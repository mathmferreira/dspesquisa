package com.devsuperior.dspesquisa.service;

import java.time.Instant;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
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
	
	@Transactional(readOnly = true)
	public Page<RecordDTO> findByMoments(String min, String max, Integer page, Integer size, String orderBy, String direction) {
		Instant minDate = ("".equals(min)) ? null : Instant.parse(min);
		Instant maxDate = ("".equals(max)) ? null : Instant.parse(max);
		
		if (size == 0) {
			size = Integer.MAX_VALUE;
		}
		
		PageRequest pageRequest = PageRequest.of(page, size, Direction.valueOf(direction), orderBy);
		return repository.findByMoments(minDate, maxDate, pageRequest).map(RecordDTO::new);
	}
	
}
