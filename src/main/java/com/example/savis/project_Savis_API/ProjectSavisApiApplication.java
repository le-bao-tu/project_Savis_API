package com.example.savis.project_Savis_API;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.savis.project_Savis_API.Config.AES;

@SpringBootApplication
public class ProjectSavisApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProjectSavisApiApplication.class, args);
		System.out.println("đây là passwork của lê bảo tú " + AES.decrypt("zZziISTZzUPxBj3sKRb/mQ==", "lebaotu@gmail.com"));
	}

	
}
