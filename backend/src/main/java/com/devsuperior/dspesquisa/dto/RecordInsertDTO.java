package com.devsuperior.dspesquisa.dto;

import java.io.Serializable;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @NoArgsConstructor
@SuppressWarnings("serial")
public class RecordInsertDTO implements Serializable {
	
	private String name;
	private Integer age;
	private Long idGame;
	

}
