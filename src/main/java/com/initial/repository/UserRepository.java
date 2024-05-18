package com.initial.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.initial.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
