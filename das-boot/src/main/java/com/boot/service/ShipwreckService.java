package com.boot.service;

import java.util.List;

import com.boot.model.Shipwreck;
import com.boot.model.ShipwreckReport;

public interface ShipwreckService {
	
	Shipwreck save(Shipwreck shipwreck);
	
	List<Shipwreck> findAll();
	
	Shipwreck getById(Long id);
	
	Shipwreck update(Long id, Shipwreck shipwreck);
	
	Shipwreck delete(Long id);
	
	List<ShipwreckReport> findAllShipwreckReports();

}
