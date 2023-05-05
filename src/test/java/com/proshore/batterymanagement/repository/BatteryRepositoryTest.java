package com.proshore.batterymanagement.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.Arrays;
import java.util.List;

import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.proshore.batterymanagement.entity.Battery;

@RunWith(SpringRunner.class)
@SpringBootTest
class BatteryRepositoryTest {

	@Autowired
	private BatteryRepository batteryRepository;

	@BeforeEach
	public void setUp() {
		Battery battery1 = new Battery();
		battery1.setId(1L);
		battery1.setName("Battery 1");
		battery1.setCapacity(100);

		Battery battery2 = new Battery();
		battery2.setId(2L);
		battery2.setName("Battery 2");
		battery2.setCapacity(200);

		List<Battery> batteries = Arrays.asList(battery1, battery2);

		batteryRepository.saveAll(batteries);
	}

	@Test
	public void testFindAll() {
		
		List<Battery> retrievedBatteries = batteryRepository.findAll();
		assertEquals(2, retrievedBatteries.size());
	}

	@Test
	public void testFindById() {
		Battery battery = batteryRepository.findById(1L).orElse(null);
		assertNotNull(battery);
		assertEquals("Battery 1", battery.getName());
	}

	@Test
	public void testSave() {
		Battery battery = new Battery();
		battery.setName("New Battery");
		battery.setCapacity(5000L);
		battery.setPostcode("12345");
		batteryRepository.save(battery);

		Battery savedBattery = batteryRepository.findById(battery.getId()).orElse(null);
		assertNotNull(savedBattery);
		assertEquals("New Battery", savedBattery.getName());
		assertEquals(5000L, savedBattery.getCapacity());
		assertEquals("12345", savedBattery.getPostcode());
	}



}
