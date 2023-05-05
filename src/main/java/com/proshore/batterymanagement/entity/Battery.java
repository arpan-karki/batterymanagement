package com.proshore.batterymanagement.entity;

import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

@Entity
public class Battery {

	@jakarta.persistence.Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	long id;

	long capacity;

	String name;

	String postcode;

	public Battery() {
	}

	public Battery(long id, String name, long capacity, String postcode) {
		this.id = id;
		this.capacity = capacity;
		this.name = name;
		this.postcode = postcode;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPostcode() {
		return postcode;
	}

	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}

	public long getCapacity() {
		return capacity;
	}

	public void setCapacity(long capacity) {
		this.capacity = capacity;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Battery other = (Battery) obj;
		return id == other.id;
	}

	@Override
	public String toString() {
		return "Battery [id=" + id + ", capacity=" + capacity + ", name=" + name + ", postcode=" + postcode + "]";
	}
	
	
}
