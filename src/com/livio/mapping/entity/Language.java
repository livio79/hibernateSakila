package com.livio.mapping.entity;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import org.hibernate.annotations.UpdateTimestamp;


@Entity 
@Table(name="language")
public class Language {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="language_id")
	private int languageId;
	
	@Column(name="name")
	private String name;
	
	@Column(name="last_update")
	@UpdateTimestamp
	private LocalDateTime lastUpdate;
	
	@OneToMany(mappedBy="language")
	private List<Film> films = new ArrayList<>();
	
	public void addFilm(Film film) {
		films.add(film);
		film.setLanguage(this);
	}
	
	public void removeFilm(Film film) {
		films.remove(film);
		film.setLanguage(null);
	}
	
	
	@OneToMany(mappedBy="originalLanguage")
	private List<Film> originalFilms = new ArrayList<>();
	
	public void addOriginalFilm(Film film) {
		originalFilms.add(film);
		film.setOriginalLanguage(this);
	}
	
	public void removeOriginalFilm(Film film) {
		originalFilms.remove(film);
		film.setOriginalLanguage(null);
	}
	
	
	public Language() {}

	public Language(String name) {
		super();
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Language [languageId=" + languageId + ", name=" + name + ", lastUpdate=" + lastUpdate + "]";
	}
	
}

