package com.initial.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.initial.entity.Certificate;
import com.initial.entity.Student;
import com.initial.service.StudentService;

@RestController
public class StudentController {
	@Autowired
	StudentService studentServ;

	@PostMapping("/addStudent")
	public Student saveStudent(@RequestBody Student student) {
		studentServ.addStudent(student);
		return student;
	}

	@PutMapping("/updateStudent/{id}")
	public String updateStudent(@PathVariable long id, @RequestBody Student student) {
		return studentServ.updateStudent(id, student);
	}

	@GetMapping("/searchStudent/{id}")
	public Student getStudent(@PathVariable long id) {
		return studentServ.searchStudentById(id);
	}

	@DeleteMapping("/deleteStudent/{id}")
	public boolean deleteStudent(@PathVariable long id) {
		return studentServ.deletelStudentById(id);
	}

	@GetMapping("/showStudents")
	public List<Student> getAllStudents() {
		return studentServ.getAllStudents();
	}
	
	@PostMapping("/addCertificateInStudent/{id}")
    public String addCertificate(@PathVariable Long id, @RequestBody Certificate certificate) {
        boolean added = studentServ.addCertificate(id, certificate);
        if (added) {
            return "Certificate added successfully";
        } else {
        	return "Student Not Found";
        }
    }

    @PutMapping("/updateCertificateInStudent/{id}")
    public String updateCertificate(@PathVariable Long id, @RequestBody Certificate updatedCertificate) {
        boolean updated = studentServ.updateCertificate(id, updatedCertificate);
        if (updated) {
            return "Certificate Updated Successfully";
        } else {
        	return "Certificate Not Found";
        }
    }

}
