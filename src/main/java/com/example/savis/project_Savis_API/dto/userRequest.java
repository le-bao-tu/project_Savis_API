package com.example.savis.project_Savis_API.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class userRequest {
	public Integer page;
	public Integer size;
	public Integer listWorkId;
	public Integer accId;
}
