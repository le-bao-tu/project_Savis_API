package com.example.savis.project_Savis_API.Model;

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

	public String account;
	
	public String list_Work;
}
