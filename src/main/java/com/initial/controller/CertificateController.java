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
import com.initial.service.CertificateService;

@RestController
public class CertificateController {
	@Autowired
	CertificateService certServ;

	@PostMapping("/addCertificate")
	public Certificate saveCertificate(@RequestBody Certificate certificate) {
		certServ.addCertificate(certificate);
		return certificate;
	}

	@PutMapping("/updateCertificate/{id}")
	public String updateCertificate(@PathVariable long id, @RequestBody Certificate certificate) {
		return certServ.updateCertificate(id, certificate);
	}

	@GetMapping("/searchCertificate/{id}")
	public Certificate getCertificate(@PathVariable long id) {
		return certServ.searchCertificate(id);
	}

	@DeleteMapping("/deleteCertificate/{id}")
	public String deleteCertificate(@PathVariable long id) {
		return certServ.deleteCertificateById(id);
	}

	@GetMapping("/showCertificates")
	public List<Certificate> getAllCertificates() {
		return certServ.getAllCertificates();
	}
}