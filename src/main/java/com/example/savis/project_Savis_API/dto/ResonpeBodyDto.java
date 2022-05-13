package com.example.savis.project_Savis_API.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ResonpeBodyDto<E> {
	public String messageCode;
	public String message;
	private Integer pageNumber;
	public E data;
	
	
	
}
