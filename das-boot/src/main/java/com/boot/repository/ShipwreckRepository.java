package com.boot.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.boot.model.Shipwreck;
import com.boot.model.ShipwreckReport;

@Repository("shipwreckRepository")
public interface ShipwreckRepository extends JpaRepository<Shipwreck, Long> {
	
	@Query("Select new com.boot.model.ShipwreckReport(s.name, s.depth, s.latitude, s.longitude) "
			+ "from Shipwreck s")
	List<ShipwreckReport> findAllShipwreckReports();

}
