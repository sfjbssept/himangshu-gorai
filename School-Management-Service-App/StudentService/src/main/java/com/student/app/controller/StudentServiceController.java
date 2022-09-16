package com.student.app.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.student.app.entity.Student;

@RestController
public class StudentServiceController {

	private static Map<String, List<Student>> schoolDB = new HashMap<>();

	static {

		List<Student> list = new ArrayList<>();
		Student std = new Student("Vishal", "Class 12");
		Student std1 = new Student("Himangshu", "Class 12");

		list.add(std);
		list.add(std1);

		schoolDB.put("School1", list);

	}

	@RequestMapping(value = "/getStudentDetailsForSchool/{schoolname}", method = RequestMethod.GET)
	public List<Student> getStudents(@PathVariable String schoolname) {

		System.out.println("Getting list of school" + schoolname);

		List<Student> studentList = schoolDB.get(schoolname);

		if (studentList == null) {
			studentList = new ArrayList<>();
			studentList.add(new Student("Not Found", "N/A"));
		}

		return studentList;

	}

}
