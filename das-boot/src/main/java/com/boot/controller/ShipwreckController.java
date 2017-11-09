package com.boot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
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

/*
To AngularJS without a Webserver:

1. Disable Same Origin Policy on Chrome:
For Chrome Browser on MacOS:

For achieving the same on mac system, for chrome browser use the following command on terminal:
open -a Google\ Chrome --args --disable-web-security --user-data-dir --allow-file-access-from-files

##################################
For Chrome Browser on Linux:

For achieving the same on Linux desktop distros (for example, on Ubuntu), for chrome browser use the following command on terminal:
google-chrome --disable-web-security --user-data-dir --allow-file-access-from-files

2. Add to $resource declaration the http address of the RESTFul service:
'http://localhost:8080/api/v1/shipwrecks/:id'
*/

@CrossOrigin
@RestController
@RequestMapping("/api/v1/")
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
