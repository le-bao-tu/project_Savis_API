package com.example.savis.project_Savis_API.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "account")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Account implements Serializable {
	
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "Id")
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "Name")
	private String name;
	
	@Column(name = "Password")
	private String password;
	
	@Column(name = "Role")
	private Integer role;
	
	@Column(name = "Email")
	private String email;
	
	@Column(name = "Status")
	private Boolean status;
	
	@JsonIgnore
	@OneToMany(mappedBy = "account" , cascade = CascadeType.ALL)
	private List<User_ListWork> userListWork;
	
	@JsonIgnore
	@OneToMany(mappedBy = "account" , cascade = CascadeType.ALL)
	private List<Comment> comments;
}
