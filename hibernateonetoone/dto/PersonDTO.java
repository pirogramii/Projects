package com.jspiders.hibernateonetoone.dto;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name = "person")
public class PersonDTO {

	@Id
	private int id ;
	private String name ;
	private char gender ;
	private String address ;
	@OneToOne
	private AadharDTO addhar ;
	
}
