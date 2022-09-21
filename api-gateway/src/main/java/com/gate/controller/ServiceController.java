package com.gate.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class ServiceController {

	@Autowired
	private RestTemplate restTemplate;
	
	@GetMapping("/getschooldetails/{schoolName}")
	public String getStudents(@PathVariable("schoolName") String schoolName) {
		
		System.out.println("Gettin School details for school : "+schoolName);
		
		String response = restTemplate.exchange("http://school-service/schooldetails/{schoolName}", HttpMethod.GET,null, new ParameterizedTypeReference<String>() {
		},schoolName).getBody();
		
		return response;
	}
}
