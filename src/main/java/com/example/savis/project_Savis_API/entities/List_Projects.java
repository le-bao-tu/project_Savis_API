package com.example.savis.project_Savis_API.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Table(name = "List_Project")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class List_Projects implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column( name = "Id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	
	@Column( name = "Name")
	private String name;
	
	@Column (name = "Status")
	private Boolean status;
	
	@Column (name = "Role")
	private Boolean role;
	
	@JsonIgnore
	@OneToMany(mappedBy = "list_Projects" , cascade = CascadeType.ALL)
	private List<List_Work> listWord;
	
}
