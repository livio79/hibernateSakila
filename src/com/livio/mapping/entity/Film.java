package com.livio.mapping.entity;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Table(name="film")
public class Film {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="film_id")
	private int filmId;
	
	@Column(name="title")
	private String title;
	
	@Column(name="description")
	private String description;
	 
	@Column(name="release_year")
	private String releaseYear;
	 
	@Column(name="language_id")
	private byte languageId;

	@Column(name="rental_duration")
	private byte rentalDuration;
	 
	@Column(name="rental_rate")
	private Double rental_rate;
	
	@Column(name="length")
	private Short length;
	
	@Column(name="replacement_cost")
	private Double replacement_cost;
	 	
	@Column(name="rating")
	private String rating;
	
	@Column(name="special_features")
	private String specialFeatures;
	
	@Column(name="last_update")
	@UpdateTimestamp					 
	private LocalDateTime lastUpdate;
	
	// ********************************************************************************ACTOR
	
	@ManyToMany(fetch=FetchType.LAZY, 
		    cascade= {CascadeType.PERSIST, CascadeType.MERGE,
		     CascadeType.DETACH, CascadeType.REFRESH})
	@JoinTable(
			name="film_actor",
			joinColumns=@JoinColumn(name="film_id"),
			inverseJoinColumns=@JoinColumn(name="actor_id")
			)
	List<Actor> actors =new ArrayList<>();
	
	
	
	public void addActor(Actor actor) {
		actors.add(actor);
		actor.getFilms().add(this);
	}
	
	public void removeActor(Actor actor) {
		actors.remove(actor);
		actor.getFilms().add(null); //remove(this
	}
	
	public List<Actor> getActors() {
		return actors;
	}

	public void setActors(List<Actor> actors) {
		this.actors = actors;
	}
	
	//************************************************************************************CATEGORY
	
	@ManyToMany(fetch=FetchType.LAZY, 
		    cascade= {CascadeType.PERSIST, CascadeType.MERGE,
		     CascadeType.DETACH, CascadeType.REFRESH})
	@JoinTable(
			name="film_category",
			joinColumns=@JoinColumn(name="film_id"),
			inverseJoinColumns=@JoinColumn(name="category_id")
			)
	List<Category> categories = new ArrayList<>();
	
	
	
	public void addCategory(Category category) {
		categories.add(category);
	}
	// *******************************************************************************************CATEGORY
	
	//************************************************************Inventory
		 
		@OneToMany(mappedBy="film")
		List<Inventory> inventories = new ArrayList<>();
		
		public void addInventory(Inventory inventory) {
			inventories.add(inventory);
			inventory.setFilm(this);
			
		}
		public void removeInventory(Inventory inventory) {
			inventories.remove(inventory);
			inventory.setFilm(null);
		}
		 
		//************************************************************Inventory	
	
	
	Film() {}
 
	public Film(String title, String description, String releaseYear ,byte languageId, byte rentalDuration, Double rental_rate, Short length, Double replacement_cost, String rating,
			String specialFeatures) {
		super();
		this.title = title;
		this.description = description;
		this.releaseYear = releaseYear; 
		this.languageId = languageId;
		this.rentalDuration = rentalDuration;
		this.rental_rate = rental_rate;
		this.length = length;
		this.replacement_cost = replacement_cost;
		this.rating = rating;
		this.specialFeatures = specialFeatures;
	}
	
 

	public int getFilmId() {
		return filmId;
	}

	public void setFilmId(int filmId) {
		this.filmId = filmId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public String getReleaseYear() {
		return releaseYear;
	}

	public void setReleaseYear(String releaseYear) {
		this.releaseYear = releaseYear;
	}

	public byte getLanguage() {
		return languageId;
	}

	public void setLanguage(byte languageId) {
		this.languageId = languageId;
	}

	public byte getRentalDuration() {
		return rentalDuration;
	}

	public void setRentalDuration(byte rentalDuration) {
		this.rentalDuration = rentalDuration;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getRating() {
		return rating;
	}

	public Double getRental_rate() {
		return rental_rate;
	}

	public void setRental_rate(Double rental_rate) {
		this.rental_rate = rental_rate;
	}

	public Short getLength() {
		return length;
	}

	public void setLength(Short length) {
		this.length = length;
	}

	public Double getReplacement_cost() {
		return replacement_cost;
	}

	public void setReplacement_cost(Double replacement_cost) {
		this.replacement_cost = replacement_cost;
	}

	public void setRating(String rating) {
		this.rating = rating;
	}

	public String getSpecialFeatures() {
		return specialFeatures;
	}


	public void setSpecialFeatures(String specialFeatures) {
		this.specialFeatures = specialFeatures;
	}
	
 public LocalDateTime getLastUpdate() {
		return lastUpdate;
	}

	public void setLastUpdate(LocalDateTime lastUpdate) {
		this.lastUpdate = lastUpdate;
	}

 

	@Override
	public String toString() {
		return "Film [filmId=" + filmId + ", title=" + title + ", description=" + description + ", releaseYear="
				+ releaseYear + ", languageId=" + languageId + ", originalLanguageId=" 	+ ", rentalDuration=" + rentalDuration + ", rental_rate=" + rental_rate + ", length=" + length
				+ ", replacement_cost=" + replacement_cost + ", rating=" + rating + ", specialFeatures="
				+ specialFeatures + ", lastUpdate=" + lastUpdate + "]";
	}

	

}

 