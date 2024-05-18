package com.initial.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.initial.entity.Placement;
import com.initial.service.PlacementService;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
public class PlacementController {
	@Autowired
	PlacementService placServ;

	@PostMapping("/addPlacement")
	public Placement savePlacement(@RequestBody Placement placement) {
		placServ.addPlacement(placement);
		return placement;
	}

	@PutMapping("/updatePlacement/{id}")
	public String updatePlacement(@PathVariable long id, @RequestBody Placement placement) {
		return placServ.updatePlacement(id, placement);
	}

	@GetMapping("/searchPlacement/{id}")
	public Placement getPlacement(@PathVariable long id) {
		return placServ.searchPlacement(id);
	
	}

	@DeleteMapping("/cancelPlacement/{id}")
	public boolean cancelPlacement(@PathVariable Long id) {
		return placServ.cancelPlacementById(id);
	}

	@GetMapping("/showPlacements")
	public List<Placement> getAllPlacements() {
		return placServ.getAllPlacements();
	}
}
