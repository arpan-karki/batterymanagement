package com.proshore.batterymanagement.controller;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.proshore.batterymanagement.entity.Battery;
import com.proshore.batterymanagement.exception.InvalidRangeException;
import com.proshore.batterymanagement.service.BatteryService;
import com.proshore.batterymanagement.utils.ListStatisticsUtils;

@RestController
public class BatteryController {

	@Autowired
	BatteryService batteryService;

	@GetMapping(path = "/batteries")
	public List<Battery> listAllBatteries() {
		return batteryService.findAll();
	}

	@PostMapping(path = "/add")
	public void addBatteries(@RequestBody List<Battery> batteries) {
		System.out.println(batteries);
		batteryService.addList(batteries);
		return;
	}

	@GetMapping(path = "/fetchBatteriesFromRange/")
	public HashMap<String, Object> fetchBatteriesInPostalRange(@RequestParam String range) throws Exception {
		String[] rangeValues = range.split("-");
		Arrays.sort(rangeValues);
		if (rangeValues.length != 2) {
			throw new InvalidRangeException("Invalid Range Supplied");
		}
		return ListStatisticsUtils.generateStats(
				batteryService.fetchDataBetweenRange(Long.parseLong(rangeValues[0]), Long.parseLong(rangeValues[1])));
	}

}
