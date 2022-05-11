package com.example.savis.project_Savis_API.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ServiceResponse<T> {
	
	private int maCode;
	private String message;
	private T data;
}	
