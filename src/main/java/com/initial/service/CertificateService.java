package com.initial.service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.initial.entity.Certificate;
import com.initial.repository.CertificateRepository;

@Service
@Transactional
public class CertificateService {
	@Autowired
	CertificateRepository certRepo;

	// A service method to Add certificate
	public void addCertificate(Certificate certificate) {
		certRepo.save(certificate);
	}

	// Method to Update the Certificate Details using Id
	public String updateCertificate(long id, Certificate certificate) {
		if (searchCertificate(id) == null) {
			return "Certificate Not Found for updation";
		} else {
			certRepo.save(certificate);
			return "Record updated successfully";
		}
	}

	// Method to search Certificate using Id
	public Certificate searchCertificate(long id) {
		try {
			Optional<Certificate> op = certRepo.findById(id);
			return op.get();
		} catch (NoSuchElementException e) {
			System.out.println("No record found");
		}
		return null;
	}

	// Method to delete Certificate using id
	public String deleteCertificateById(long id) {
		if (searchCertificate(id) != null) {
			certRepo.deleteById(id);
			return "User Deleted";
		}
		return "User Not Found";
	}
	// Method to retrieve all Certificates
	public List<Certificate> getAllCertificates() {
		return certRepo.findAll();
	}
}
