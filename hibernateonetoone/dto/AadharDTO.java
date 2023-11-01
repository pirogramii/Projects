package com.jspiders.hibernateonetoone.dto;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name = "aadhar")
public class AadharDTO {

	@Id
	private int id ;
	private long aadhar_no ;
	private String doi ;
	@OneToOne
	private PersonDTO person ;
	
}
