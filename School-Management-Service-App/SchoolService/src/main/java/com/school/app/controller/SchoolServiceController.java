package com.school.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/schooldetails")
public class SchoolServiceController {

	@Autowired
	private RestTemplate restTemplate;

	@GetMapping("/{schoolname}")
	public String getStudentDetials(@PathVariable("schoolname") String schoolname) {

		System.out.println("Getting School Details for " + schoolname);

		String requestURL = "http://localhost:9091/getStudentDetailsForSchool/" + schoolname;

		HttpHeaders httpHeaders = new HttpHeaders();
		HttpEntity<String> httpEntity = new HttpEntity<>(httpHeaders);

		ResponseEntity<String> response = restTemplate.exchange(requestURL, HttpMethod.GET, httpEntity, String.class);
		String student = response.getBody();

		System.out.println("Response received as " + student);

		return "School Name " + schoolname + " and Student Details " + student;
	}

}
