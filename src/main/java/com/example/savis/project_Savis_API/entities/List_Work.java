package com.example.savis.project_Savis_API.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.Optional;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "List_Work")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class List_Work implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column( name = "Id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	
	@Column(name = "Name")
	private String name;
	
	@Column( name = "Status")
	private Boolean status;
	
	@Column ( name = "Start_Date")
	private Date start_Date;
	
	@Column ( name = "End_Date")
	private Date end_Date;
	
	@Column ( name = "Note")
	private String note;
	
	@Column ( name = "Label")
	private Integer label;
	
	@ManyToOne
	@JoinColumn (name = "list_projectId")
	private List_Projects list_Projects;
}
