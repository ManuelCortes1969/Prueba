package com.example.demo.entities;

import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.ForeignKey;

@Entity
@Table(name = "phones")
public class Phone {
    
	@Id 
	@GeneratedValue(strategy = GenerationType.UUID)
    private UUID id; 
   
    private String number;
    
    private String citycode;
    
    private String countrycode;
 
    @JsonBackReference
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(foreignKey = @ForeignKey(name="SYS_FK_10392"), name="user_id", nullable=false, referencedColumnName="id", columnDefinition = "UUID")
    private User user;
       
    public Phone() {
	
	}

    public Phone(UUID id, String number, String citycode, String countrycode, User user) {    	
		super();
		this.id = id;
		this.number = number;
		this.citycode = citycode;
		this.countrycode = countrycode;
		this.user = user;
	}


	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getCitycode() {
		return citycode;
	}

	public void setCitycode(String citycode) {
		this.citycode = citycode;
	}

	public String getCountrycode() {
		return countrycode;
	}

	public void setCountrycode(String countrycode) {
		this.countrycode = countrycode;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "Phone [id=" + id + ", number=" + number + ", citycode=" + citycode
				+ ", countrycode=" + countrycode + "]";
	}

}