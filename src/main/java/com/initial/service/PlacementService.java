package com.initial.service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.initial.entity.Placement;
import com.initial.repository.PlacementRepository;

@Service
@Transactional
public class PlacementService {
	@Autowired
	PlacementRepository placeRepo;

	// A service method to Add placement
	public void addPlacement(Placement placement) {
		placeRepo.save(placement);
	}

	// Method to Update the Placement Details using Id
	public String updatePlacement(long id, Placement placement) {
		if (searchPlacement(id) == null) {
			return "Placement Not Found for updation";
		} else {
			placeRepo.save(placement);
			return "Record updated successfully";
		}
	}

	// Method to search Placement using Id
	public Placement searchPlacement(long id) {
		try {
			Optional<Placement> op = placeRepo.findById(id);
			return op.get();
		} catch (NoSuchElementException e) {
			System.out.println("No record found");
		}
		return null;
	}

	// Method to delete Placement using id
	public boolean cancelPlacementById(Long id) {
		if (searchPlacement(id) != null) {
			placeRepo.deleteById(id);
			return true;
		}
		return false;		
	}

	// Method to retrieve all Placements
	public List<Placement> getAllPlacements() {
		return placeRepo.findAll();
	}
}
