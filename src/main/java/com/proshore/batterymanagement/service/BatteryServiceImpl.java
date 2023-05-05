package com.proshore.batterymanagement.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.proshore.batterymanagement.entity.Battery;
import com.proshore.batterymanagement.repository.BatteryRepository;

@Service
public class BatteryServiceImpl implements BatteryService {

	@Autowired
	BatteryRepository batteryRepository;

	@Override
	public List<Battery> findAll() {
		// TODO Auto-generated method stub
		return batteryRepository.findAll();
	}

	@Override
	public void addList(List<Battery> batteries) {
		batteryRepository.saveAll(batteries);
	}

	@Override
	public List<Battery> fetchDataBetweenRange(long startCode, long endCode) {
		// TODO Auto-generated method stub

		List<Battery> batteries = batteryRepository.findAll(Sort.by("name").ascending());
		if (batteries != null) {
			batteries = batteries.stream()
					.filter(battery -> battery.getPostcode().compareTo(String.valueOf(startCode)) >= 0
							&& battery.getPostcode().compareTo(String.valueOf(endCode)) <= 0)
					.collect(Collectors.toList());

		}
		return batteries;
	}

}
