package com.chitra.school.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="TB_CLASSROOM")
public class Classroom {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	public final long getId() {
		return id;
	}

	public final void setId(long id) {
		this.id = id;
	}
	
	

}
