package com.devsuperior.dspesquisa.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tb_genre")
@Data @NoArgsConstructor @AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@SuppressWarnings("serial")
public class Genre implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@EqualsAndHashCode.Include
	@Column(name = "id_genre", nullable = false)
	private Long id;
	
	@Column(name = "name", nullable = false)
	private String name;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "genre", cascade = CascadeType.ALL)
	private List<Game> games = new ArrayList<>();

}
