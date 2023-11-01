package com.jspiders.hibnernatemanytomany.dto;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name = "course")

public class CourseDTO {

	@Id
	private int id ;
	private String name ;
	private int duration ;
}
