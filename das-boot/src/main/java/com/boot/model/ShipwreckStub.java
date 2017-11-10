package com.boot.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ShipwreckStub {
	private static Map<Long, Shipwreck> wrecks = new HashMap<>();
	private static Long idIndex = 3L;
	
	private ShipwreckStub() {}

	//populate initial wrecks
	static {
		Shipwreck a = new Shipwreck();
		a.setId(1L);
		a.setName("U869");
		a.setDescription("A very deep German UBoat");
		a.setCondition("FAIR");
		a.setDepth(200);
		a.setLatitude(44.12);
		a.setLongitude(138.44);
		a.setYearDiscovered(1994);
		wrecks.put(1L, a);
		
		Shipwreck b = new Shipwreck();
		b.setId(2L);
		b.setName("Thistlegorm");
		b.setDescription("British merchant boat in the Red Sea");
		b.setCondition("GOOD");
		b.setDepth(80);
		b.setLatitude(44.12);
		b.setLongitude(138.44);
		b.setYearDiscovered(1994);
		wrecks.put(2L, b);
		
		Shipwreck c = new Shipwreck();
		c.setId(3L);
		c.setName("S.S. Yongala");
		c.setDescription("A luxury passenger ship wrecked on the great barrier reef");
		c.setCondition("FAIR");
		c.setDepth(50);
		c.setLatitude(44.12);
		c.setLongitude(138.44);
		c.setYearDiscovered(1994);
		wrecks.put(3L, c);
	}

	public static List<Shipwreck> list() {
		return new ArrayList<>(wrecks.values());
	}

	public static Shipwreck create(Shipwreck wreck) {
		idIndex += idIndex;
		wreck.setId(idIndex);
		wrecks.put(idIndex, wreck);
		return wreck;
	}

	public static Shipwreck get(Long id) {
		return wrecks.get(id);
	}

	public static Shipwreck update(Long id, Shipwreck wreck) {
		wrecks.put(id, wreck);
		return wreck;
	}

	public static Shipwreck delete(Long id) {
		return wrecks.remove(id);
	}
}
