package com.livio.mapping.entity;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;
import org.hibernate.annotations.UpdateTimestamp;


@Entity
@Table(name="city")
public class City {
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column(name="city_id")
	private int city_id;
	
	@Column(name="city")
	private String city;
	
//	@Column(name="country_id")
//	private short countryId;
	
	//************************************************************Country

	@ManyToOne 
	@JoinColumn(name = "country_id")
	private Country country;
	
	public Country getCountry() {
		return country;
	}


	public void setCountry(Country country) {
		this.country = country;
	}

	//************************************************************Country
	
	//************************************************************Address
	
	//OneToMany with Country : addCity and removeCity methods
		@OneToMany(mappedBy="city")
		List<Address> addresses = new ArrayList<>();
		
		public void addAddress(Address address) {
			addresses.add(address);
			address.setCity(this);
		}
		
		public void removeAddress(Address address) {
			addresses.remove(address);
			address.setCity(this);
		}
		//************************************************************Address
	
	@UpdateTimestamp
	@Column(name="last_update")
	private LocalDateTime lastUpdate;
	
	
	public City() {}


//	public City(String city, short countryId) {
//		super();
//		this.city = city;
//		this.countryId = countryId;
//	}
	
	//(Costrutto whitout countryId)
	public City(String city) {
		super();
		this.city = city;
	}


	public int getCity_id() {
		return city_id;
	}


	public void setCity_id(int city_id) {
		this.city_id = city_id;
	}


	public String getCity() {
		return city;
	}


	public void setCity(String city) {
		this.city = city;
	}


//	public short getCountryId() {
//		return countryId;
//	}
//
//
//	public void setCountryId(short countryId) {
//		this.countryId = countryId;
//	}


	public LocalDateTime getLastUpdate() {
		return lastUpdate;
	}


	public void setLastUpdate(LocalDateTime lastUpdate) {
		this.lastUpdate = lastUpdate;
	}
	
	
}
