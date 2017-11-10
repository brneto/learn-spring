package com.boot;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.boot.controller.ShipwreckController;
import com.boot.model.Shipwreck;
import com.boot.service.ShipwreckService;

public class ShipwreckControllerTest {
	@InjectMocks
	private ShipwreckController sc;
	
	@Mock
	private ShipwreckService shipwreckService;
	
	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void testShipwreckGet() {
		Shipwreck sw = new Shipwreck();
		sw.setId(1L);
		when(shipwreckService.getById(1L)).thenReturn(sw);
		
		Shipwreck wreck = sc.get(1L);
		
		verify(shipwreckService).getById(1L);
		
		//assertEquals(1L, wreck.getId().longValue());
		assertThat(wreck.getId(), equalTo(1L));
	}

}
