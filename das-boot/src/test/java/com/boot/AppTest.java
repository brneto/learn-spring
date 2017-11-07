package com.boot;

import org.junit.Test;

import com.boot.controller.HomeController;

import org.junit.Assert;

public class AppTest {
    
	@Test
	public void testApp() {
		HomeController hc = new HomeController();
		String result = hc.home();
        Assert.assertEquals(result, "Das Boot, reporting for duty!");
    }
}
