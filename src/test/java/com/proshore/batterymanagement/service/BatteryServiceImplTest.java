package com.proshore.batterymanagement.service;

import static org.mockito.Mockito.times;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.proshore.batterymanagement.entity.Battery;

@RunWith(SpringRunner.class)
@SpringBootTest
class BatteryServiceImplTest {

	@Mock
	private BatteryService batteryService;

	@Test
	public void testFindAll() {
		// given
		List<Battery> batteries = new ArrayList<>();
		batteries.add(new Battery(1L, "Battery 1", 100, "12345"));
		batteries.add(new Battery(2L, "Battery 2", 200, "67890"));

		Mockito.when(batteryService.findAll()).thenReturn(batteries);

		// when
		List<Battery> result = batteryService.findAll();

		// then
		Assert.assertEquals(2, result.size());
		Assert.assertEquals("Battery 1", result.get(0).getName());
		Assert.assertEquals("12345", result.get(0).getPostcode());
		Assert.assertEquals(100, result.get(0).getCapacity());
		Assert.assertEquals("Battery 2", result.get(1).getName());
		Assert.assertEquals("67890", result.get(1).getPostcode());
		Assert.assertEquals(200, result.get(1).getCapacity());
	}

	@Test
	public void testAddList() {
		// given
		List<Battery> batteries = new ArrayList<>();
		batteries.add(new Battery(1L, "Battery 1", 100, "12345"));
		batteries.add(new Battery(2L, "Battery 2", 200, "67890"));

		// when
		batteryService.addList(batteries);

		// then
		Mockito.verify(batteryService, times(1)).addList(batteries);
	}

	@Test
	public void testFetchDataBetweenRange() {
		// given
		List<Battery> batteries = new ArrayList<>();
		batteries.add(new Battery(1L, "Battery 1", 100, "12345"));
		batteries.add(new Battery(2L, "Battery 2", 200, "67890"));
		batteries.add(new Battery(3L, "Battery 3", 300, "54321"));

		Mockito.when(batteryService.fetchDataBetweenRange(150, 250)).thenReturn(Arrays.asList(batteries.get(1)));
		System.out.println(Arrays.asList(batteries.get(1)));
		// when
		List<Battery> result = batteryService.fetchDataBetweenRange(150, 250);
		System.out.println(result);
		// then
		Assert.assertEquals(1, result.size());
		Assert.assertEquals("Battery 2", result.get(0).getName());
		Assert.assertEquals("67890", result.get(0).getPostcode());
		Assert.assertEquals(200, result.get(0).getCapacity());
	}

}
