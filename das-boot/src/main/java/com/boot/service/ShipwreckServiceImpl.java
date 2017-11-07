package com.boot.service;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.boot.model.Shipwreck;
import com.boot.model.ShipwreckReport;
import com.boot.repository.ShipwreckRepository;

@Service("shipwreckService")
public class ShipwreckServiceImpl implements ShipwreckService {
	
	@Autowired
	private ShipwreckRepository shipwreckRepository;

	@Transactional
	@Override
	public Shipwreck save(Shipwreck shipwreck) {
		return shipwreckRepository.saveAndFlush(shipwreck);
	}
	
	@Override
	public List<Shipwreck> findAll() {
		return shipwreckRepository.findAll();
	}

	@Override
	public Shipwreck getById(Long id) {
		return shipwreckRepository.findOne(id);
	}

	@Override
	public Shipwreck update(Long id, Shipwreck shipwreck) {
		Shipwreck existingShipwreck = shipwreckRepository.findOne(id);
		BeanUtils.copyProperties(shipwreck, existingShipwreck);
		return shipwreckRepository.saveAndFlush(existingShipwreck);
	}

	@Override
	public Shipwreck delete(Long id) {
		Shipwreck existingShipwreck = shipwreckRepository.findOne(id);
		shipwreckRepository.delete(existingShipwreck);
		return existingShipwreck;
	}

	@Override
	public List<ShipwreckReport> findAllShipwreckReports() {
		return shipwreckRepository.findAllShipwreckReports();
	}

}
