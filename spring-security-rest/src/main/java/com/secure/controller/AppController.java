package com.secure.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.secure.data.Employee;

@RestController
public class AppController {

	@GetMapping("/get")
	public String getDetails() {
		return "Get Details";
	}

	@PostMapping("/post")
	public String addEmployee(@RequestBody Employee employee) {
		return "Employee";
	}

	@PutMapping("/put/{name}")
	public String updateEmployee(@RequestBody Employee employee, @PathVariable("name") String name) {
		return "Update Employee with name " + name;
	}

}
