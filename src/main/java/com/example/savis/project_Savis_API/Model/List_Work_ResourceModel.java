package com.example.savis.project_Savis_API.Model;

import java.util.Date;

import com.example.savis.project_Savis_API.entities.List_Projects;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class List_Work_ResourceModel {
	
	public Integer id;
	
	public String name;
	
	public Boolean status;
	
	public Date start_Date;
	
	public Date end_Date;
	
	public String note;
	
	public Integer label;
	
	public Boolean role;
	
	public String list_project_id;
	

}
