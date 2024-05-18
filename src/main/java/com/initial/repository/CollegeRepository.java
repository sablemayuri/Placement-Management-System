package com.initial.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.initial.entity.College;

public interface CollegeRepository extends JpaRepository<College, Long> {

}
