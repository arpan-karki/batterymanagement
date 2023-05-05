package com.proshore.batterymanagement.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.proshore.batterymanagement.entity.Battery;

public interface BatteryService {

	List<Battery> findAll();

	void addList(List<Battery> batteries);

	List<Battery> fetchDataBetweenRange(long parseLong, long parseLong2);

}
