package com.livio.mapping.entity;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.*;

import javax.persistence.*;

import org.hibernate.annotations.CreationTimestamp;

@Entity
@Table(name="country")
public class Country  implements Serializable {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="country_id")
	private int countryId;
	
	@Column(name="country")
	private String country;
	
	@CreationTimestamp
	@Column(name="last_update")
	private LocalDateTime lastUpdate;
	
	@OneToMany(mappedBy="country")
	List<City> cities = new ArrayList<>();
	
	public Country() {}

	public Country(String country) {
		super();
		this.country = country;
	}

	public int getCountryId() {
		return countryId;
	}

	public void setCountryId(int countryId) {
		this.countryId = countryId;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public LocalDateTime getLastUpdate() {
		return lastUpdate;
	}

	public void setLastUpdate(LocalDateTime lastUpdate) {
		this.lastUpdate = lastUpdate;
	}

	public void addCity(City city) {
		cities.add(city);
		city.setCountry(this);
	}
	
	public void removeCity(City city) {
		cities.remove(city);
		city.setCountry(null);
	}
	
	@Override
	public String toString() {
		return "Country [countryId=" + countryId + ", country=" + country + ", lastUpdate=" + lastUpdate + "]";
	}
}
