package com.example.savis.project_Savis_API.Model;

import com.example.savis.project_Savis_API.entities.Account;
import com.example.savis.project_Savis_API.entities.List_Work;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Commnet_ResourceModel {
	
	public Integer id;

	public String title;
	
	public Boolean status;
	
	public Boolean role;

	public Account account;
	
	public List_Work list_Work;
}
