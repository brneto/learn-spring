package com.boot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.boot.model.Shipwreck;
import com.boot.model.ShipwreckReport;
import com.boot.service.ShipwreckService;

@RestController
@RequestMapping("api/v1/")
public class ShipwreckController {
	
	@Autowired
	private ShipwreckService shipwreckService;
	
	@GetMapping("shipwrecks")
	public List<Shipwreck> list() {
		return shipwreckService.findAll();
	}
	
	@GetMapping("shipwrecks/report")
	public List<ShipwreckReport> listReports() {
		return shipwreckService.findAllShipwreckReports();
	}
	
	@PostMapping("shipwrecks")
	public Shipwreck create(@RequestBody Shipwreck shipwreck) {
		return shipwreckService.save(shipwreck);
	}
	
	@GetMapping("shipwrecks/{id}")
	public Shipwreck get(@PathVariable Long id) {
		return shipwreckService.getById(id);
	}
	
	@PutMapping("shipwrecks/{id}")
	public Shipwreck update(@PathVariable Long id, @RequestBody Shipwreck shipwreck) {
		return shipwreckService.update(id, shipwreck);
	}
	
	@DeleteMapping("shipwrecks/{id}")
	public Shipwreck delete(@PathVariable Long id) {
		return shipwreckService.delete(id);
	}

}
