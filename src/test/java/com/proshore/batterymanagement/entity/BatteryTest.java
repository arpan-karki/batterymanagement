package com.proshore.batterymanagement.entity;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
public class BatteryTest {

	@Test
	public void testGettersAndSetters() {
		Battery battery = new Battery();
		battery.setId(1L);
		battery.setName("Test Battery");
		battery.setCapacity(100L);
		battery.setPostcode("12345");

		assertEquals(1L, battery.getId());
		assertEquals("Test Battery", battery.getName());
		assertEquals(100L, battery.getCapacity());
		assertEquals("12345", battery.getPostcode());
	}

	@Test
	public void testEqualsAndHashCode() {
		Battery battery1 = new Battery(1L, "Test Battery", 100L, "12345");
		Battery battery2 = new Battery(1L, "Test Battery", 100L, "12345");

		assertEquals(battery1, battery2);
		assertEquals(battery1.hashCode(), battery2.hashCode());
	}
}
