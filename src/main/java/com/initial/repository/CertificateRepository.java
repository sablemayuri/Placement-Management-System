package com.initial.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.initial.entity.Certificate;

public interface CertificateRepository extends JpaRepository<Certificate, Long> {

}
