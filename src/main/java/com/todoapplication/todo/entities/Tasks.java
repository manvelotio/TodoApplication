package com.todoapplication.todo.entities;

import java.sql.Date;
import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import org.hibernate.annotations.UpdateTimestamp;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Entity
@Table(name="tasks")
@Getter
@Setter
@ToString
@NoArgsConstructor

public class Tasks {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int tId;
	
	@NotBlank(message = "Please enter the description")
	private String taskDesc;
	
	@UpdateTimestamp
	private Timestamp creationDate;
	
	private Date targetDate;  // status column
	
	private Boolean 
	
	@ManyToOne
	private User user;
	
	
	

}
