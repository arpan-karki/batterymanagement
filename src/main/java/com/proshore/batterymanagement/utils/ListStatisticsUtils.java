package com.proshore.batterymanagement.utils;

import java.util.HashMap;
import java.util.List;

import com.proshore.batterymanagement.entity.Battery;

public class ListStatisticsUtils {

	public static HashMap<String, Object> generateStats(List<Battery> batteries) {
		HashMap<String, Object> batteryStats = new HashMap<String, Object>();
		int count = batteries.size();
		long avgCapacity = 0L;
		long maxCapacity = batteries.get(0).getCapacity();
		long minCapacity = batteries.get(0).getCapacity();
		for (Battery battery : batteries) {
			if (battery.getCapacity() > maxCapacity)
				maxCapacity = battery.getCapacity();
			if (battery.getCapacity() < minCapacity)
				minCapacity = battery.getCapacity();
			avgCapacity += battery.getCapacity();
		}
		BatteryStats batteryStat = new BatteryStats(count, avgCapacity / count, maxCapacity, minCapacity);
		batteryStats.put("stats", batteryStat);
		batteryStats.put("batteries", batteries);
		return batteryStats;
	}
}
