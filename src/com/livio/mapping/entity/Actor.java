package com.livio.mapping.entity;


 
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.*;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Table(name="actor")
public class Actor implements Serializable{

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="actor_id")
	private int id;
	
	@Column(name="first_name")
	private String firstName;
	
	@Column(name="last_name")
	private String lastName;
	
	@Column(name="last_update")
	@UpdateTimestamp					 
	private LocalDateTime lastUpdate;
	
	
	@ManyToMany(fetch=FetchType.LAZY, mappedBy="actors",
		    cascade= {CascadeType.PERSIST, CascadeType.MERGE,
		     CascadeType.DETACH, CascadeType.REFRESH})
	List<Film> films = new ArrayList<>();
	 
	
	public void addFilm(Film film) {			//INUTILE ??
		films.add(film);
	}
	
	public List<Film> getFilms() {
		return films;
	}
	public void setFilms(List<Film> films) {
		this.films = films;
	}
	// ********************************************************************************
	
		
	public Actor() {}
	
	public Actor(String firstName, String lastName   ) {
		super();
		this.firstName = firstName;
		this.lastName = lastName; 
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public LocalDateTime getLastUpdate() {
		return lastUpdate;
	}

	public void setLastUpdate(LocalDateTime lastUpdate) {
		this.lastUpdate = lastUpdate;
	}

	
	@Override
	public String toString() {
		return "Actor [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", lastUpdate=" + lastUpdate
				+ "]";
	}
	
 
	
}
