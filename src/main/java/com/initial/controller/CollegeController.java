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

import com.initial.entity.College;
import com.initial.entity.Placement;
import com.initial.service.CollegeService;

@RestController
public class CollegeController {
	@Autowired
	CollegeService collegeServ;

	@PostMapping("/addCollege")
	public College saveCollege(@RequestBody College college) {
		collegeServ.addCollege(college);
		return college;
	}

	@PutMapping("/updateCollege/{id}")
	public String updateCollege(@PathVariable long id, @RequestBody College college) {
		return collegeServ.updateCollege(id, college);
	}

	@GetMapping("/searchCollege/{id}")
	public College getCollege(@PathVariable long id) {
		return collegeServ.searchCollege(id);
	}

	@DeleteMapping("/deleteCollege/{id}")
	public boolean deleteCollege(@PathVariable long id) {
		return collegeServ.deleteCollegeById(id);
	}

	@GetMapping("/showColleges")
	public List<College> getAllColleges() {
		return collegeServ.getAllColleges();
	}

	@GetMapping("/ShedulePlacements/{id}")
	public List<Placement> getCollegePlacements(@PathVariable Long id) {
		List<Placement> placements = collegeServ.getCollegePlacements(id);
		if (placements != null) {
			return placements;
		}
		return null;

	}
}
