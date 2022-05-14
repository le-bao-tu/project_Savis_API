package com.example.savis.project_Savis_API.util;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class commentRequest  {
	public String title;
	public Integer page;
	public Integer size;
	public Integer listWorkId;
	public Integer accId;
}
