package com.boot.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.boot.model.Shipwreck;

@RestController
@RequestMapping("api/v1/")
public class ShipwreckController {
	
	@GetMapping("shipwrecks")
	public List<Shipwreck> list() {
		return ShipwreckStub.list();
	}
	
	@PostMapping("shipwrecks")
	public Shipwreck create(@RequestBody Shipwreck shipwreck) {
		return ShipwreckStub.create(shipwreck);
	}
	
	@GetMapping("shipwrecks/{id}")
	public Shipwreck get(@PathVariable Long id) {
		return ShipwreckStub.get(id);
	}
	
	@PutMapping("shipwrecks/{id}")
	public Shipwreck update(@PathVariable Long id, @RequestBody Shipwreck shipwreck) {
		return ShipwreckStub.update(id, shipwreck);
	}
	
	@DeleteMapping("shipwrecks/{id}")
	public Shipwreck delete(@PathVariable Long id) {
		return ShipwreckStub.delete(id);
	}

}
