package com.initial.service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.initial.entity.Certificate;
import com.initial.entity.Student;
import com.initial.repository.CertificateRepository;
import com.initial.repository.StudentRepository;

@Service
@Transactional
public class StudentService {

	@Autowired
	StudentRepository studentRepo;

	@Autowired
	CertificateRepository certificateRepo;

	// A service method to Add student
	public void addStudent(Student student) {
		studentRepo.save(student);
	}

	// Method to Update the Student Details using Id
	public String updateStudent(long id, Student student) {
		if (searchStudentById(id) == null) {
			return "Student Not Found for updation";
		} else {
			studentRepo.save(student);
			return "Record updated successfully";
		}
	}

	// Method to search Student using Id
	public Student searchStudentById(long id) {
		try {
			Optional<Student> op = studentRepo.findById(id);
			return op.get();
		} catch (NoSuchElementException e) {
			System.out.println("No record found");
		}
		return null;
	}

	// Method to search Student using Id
	public Student searchStudentByHallTicket(long TicketNo) {
		try {
			Optional<Student> op = studentRepo.findById(TicketNo);
			return op.get();
		} catch (NoSuchElementException e) {
			System.out.println("No record found");
		}
		return null;
	}

	public boolean addCertificate(Long id, Certificate certificate) {
		Student student = searchStudentById(id);
		if (student != null) {
			student.setCertificate(certificate);
			studentRepo.save(student);
			return true;
		}
		return false;
	}

	public boolean updateCertificate(Long id, Certificate updatedCertificate) {
		Student student = searchStudentById(id);
		if (student != null && student.getCertificate() != null) {
			Certificate existingCertificate = student.getCertificate();
			// Update certificate fields as needed
			existingCertificate.setYear(updatedCertificate.getYear());
			certificateRepo.save(existingCertificate);
			return true;
		}
		return false;
	}

	// Method to delete Student using id
	public boolean deletelStudentById(long id) {
		if (searchStudentById(id) == null) {
			studentRepo.deleteById(id);
			return false;
		}
		return true;
	}

	// Method to retrieve all Students
	public List<Student> getAllStudents() {
		return studentRepo.findAll();
	}

}
