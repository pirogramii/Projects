package com.jspiders.jpql.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name = "trainer_details")
public class TrainerDTO {

	@Id
	@Column(name = "t_id")
	private static int id ;
	@Column(name = "t_name")
	private static String name ;
	@Column(name = "t_sub")
	private static String subject ;
	@Column(name = "t_email")
	private static String email ;
	
}

