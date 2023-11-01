package com.jspiders.hibnernatemanytomany.dto;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name = "candidate")

public class CandidateDTO {

	@Id
	private int id ;
	private String name ;
	private String email ;
	private String address ;
	@ManyToMany
	private List<CourseDTO> courses ;
}
