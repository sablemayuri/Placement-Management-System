package com.initial.service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.initial.entity.College;
import com.initial.entity.Placement;
import com.initial.repository.CollegeRepository;
import com.initial.repository.PlacementRepository;

@Service
@Transactional
public class CollegeService {
	@Autowired
	CollegeRepository collegeRepo;
	@Autowired
	PlacementRepository placementRepo;

	// A service method to Add college
	public void addCollege(College college) {
		collegeRepo.save(college);
	}

	// Method to Update the College Details using Id
	public String updateCollege(long id, College college) {
		if (searchCollege(id) == null) {
			return "College Not Found for updation";
		} else {
			collegeRepo.save(college);
			return "Record updated successfully";
		}
	}

	// Method to search College using Id
	public College searchCollege(long id) {
		try {
			Optional<College> op = collegeRepo.findById(id);
			return op.get();
		} catch (NoSuchElementException e) {
			System.out.println("No record found");
		}
		return null;
	}

	// Method to delete College using id
	public boolean deleteCollegeById(long id) {
		if (searchCollege(id) == null) {
			collegeRepo.deleteById(id);
			return true;
		}
		return false;
	}
	
	public List<Placement> getCollegePlacements(Long id) {
        return null;
    }


	// Method to retrieve all Colleges
	public List<College> getAllColleges() {
		return collegeRepo.findAll();
	}
}
