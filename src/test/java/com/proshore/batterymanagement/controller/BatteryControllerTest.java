package com.proshore.batterymanagement.controller;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.proshore.batterymanagement.entity.Battery;
import com.proshore.batterymanagement.service.BatteryService;

@RunWith(SpringRunner.class)
@WebMvcTest(BatteryController.class)
public class BatteryControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private BatteryService batteryService;

	@Test
	public void listAllBatteriesTest() throws Exception {
		
		
		Battery battery1 = new Battery();
		battery1.setId(1L);
		battery1.setName("Battery 1");
		battery1.setCapacity(100);

		Battery battery2 = new Battery();
		battery2.setId(2L);
		battery2.setName("Battery 2");
		battery2.setCapacity(200);

		List<Battery> batteries = Arrays.asList(battery1, battery2);

		Mockito.when(batteryService.findAll()).thenReturn(batteries);

		mockMvc.perform(get("/batteries")).andExpect(status().isOk()).andExpect(jsonPath("$[0].name", is("Battery 1")))
				.andExpect(jsonPath("$[0].capacity", is(100))).andExpect(jsonPath("$[1].name", is("Battery 2")))
				.andExpect(jsonPath("$[1].capacity", is(200)));
	}

	@Test
	public void addBatteriesTest() throws Exception {
		ObjectMapper objectMapper = new ObjectMapper();
		Battery battery1 = new Battery();
		battery1.setId(1L);
		battery1.setName("Battery 1");
		battery1.setCapacity(100);

		Battery battery2 = new Battery();
		battery2.setId(2L);
		battery2.setName("Battery 2");
		battery2.setCapacity(200);

		List<Battery> batteries = Arrays.asList(battery1, battery2);

		mockMvc.perform(post("/add").contentType(MediaType.APPLICATION_JSON)
				.content(objectMapper.writeValueAsString(batteries))).andExpect(status().isOk());
	}

	@Test
	public void fetchBatteriesInPostalRangeTest() throws Exception {
		Battery battery1 = new Battery();
		battery1.setId(1L);
		battery1.setName("Battery 1");
		battery1.setCapacity(100);
		battery1.setPostcode("1000");

		Battery battery2 = new Battery();
		battery2.setId(2L);
		battery2.setName("Battery 2");
		battery2.setCapacity(200);
		battery2.setPostcode("2000");

		List<Battery> batteries = Arrays.asList(battery1, battery2);

		Mockito.when(batteryService.fetchDataBetweenRange(1000L, 2000L)).thenReturn(batteries);

		mockMvc.perform(get("/fetchBatteriesFromRange/").param("range", "1000-2000")).andExpect(status().isOk())
				.andExpect(jsonPath("$.stats.count", is(2))).andExpect(jsonPath("$.stats.avgCapacity", is(150)))
				.andExpect(jsonPath("$.stats.maxCapacity", is(200))).andExpect(jsonPath("$.stats.minCapacity", is(100)));
	}
}
