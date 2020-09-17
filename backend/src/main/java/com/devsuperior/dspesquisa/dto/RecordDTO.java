package com.devsuperior.dspesquisa.dto;

import java.io.Serializable;
import java.time.Instant;

import com.devsuperior.dspesquisa.entity.Record;
import com.devsuperior.dspesquisa.entity.enumerator.Platform;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @NoArgsConstructor
@SuppressWarnings("serial")
public class RecordDTO implements Serializable {

	private Long id;
	private Instant moment;
	private String name;
	private Integer age;
	private String gameTitle;
	private Platform gamePlatform;
	private String genreName;
	
	public RecordDTO(Record entity) {
		this.id = entity.getId();
		this.moment = entity.getMoment();
		this.name = entity.getName();
		this.age = entity.getAge();
		this.gameTitle = entity.getGame().getTitle();
		this.gamePlatform = entity.getGame().getPlatform();
		this.genreName = entity.getGame().getGenre().getName();
	}
	
}
