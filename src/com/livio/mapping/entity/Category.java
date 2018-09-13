package com.livio.mapping.entity;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.*;
import javax.persistence.*;
import org.hibernate.annotations.UpdateTimestamp;

@Entity 
@Table(name="category")
public class Category  implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="category_id")
	private int categoryId;
	
	@Column(name="name")
	private String name;
	
	@Column(name="last_update")
	@UpdateTimestamp
	private LocalDateTime lastUpdate;
	
	
	
	
	// ********************************************************************************FILM
	@ManyToMany(fetch=FetchType.LAZY, mappedBy="categories",
		    cascade= {CascadeType.PERSIST, CascadeType.MERGE,
		     CascadeType.DETACH, CascadeType.REFRESH})
	private List<Film> films = new ArrayList<>();
	
	
	
	public void addFilm(Film film) {
		films.add(film);
	}
	
	
	
	
	
	
	public Category() {}

	public Category(String name) {
		super();
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

	public LocalDateTime getLastUpdate() {
		return lastUpdate;
	}

	public void setLastUpdate(LocalDateTime lastUpdate) {
		this.lastUpdate = lastUpdate;
	}
	
	@Override
	public String toString() {
		return "Language [languageId=" + categoryId + ", name=" + name + ", lastUpdate=" + lastUpdate + "]";
	}
}
