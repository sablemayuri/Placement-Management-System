package com.initial.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.initial.entity.Placement;

public interface PlacementRepository extends JpaRepository<Placement, Long> {

}
