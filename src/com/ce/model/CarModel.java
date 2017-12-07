package com.ce.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;


@Entity
@Table(name="cs_carmodel")
public class CarModel {
	
	private int Id;
	private String Name;

	@GeneratedValue
	@Id
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}

	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}

}
