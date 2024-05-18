package com.initial.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.initial.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {

}
