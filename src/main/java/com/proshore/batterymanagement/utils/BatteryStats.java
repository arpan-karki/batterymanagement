package com.proshore.batterymanagement.utils;

public class BatteryStats {
	int count;
	long avgCapacity;
	long maxCapacity;
	long minCapacity;

	public BatteryStats(int count, long avgCapacity, long maxCapacity, long minCapacity) {
		this.count = count;
		this.avgCapacity = avgCapacity;
		this.maxCapacity = maxCapacity;
		this.minCapacity = minCapacity;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public long getAvgCapacity() {
		return avgCapacity;
	}

	public void setAvgCapacity(long avgCapacity) {
		this.avgCapacity = avgCapacity;
	}

	public long getMaxCapacity() {
		return maxCapacity;
	}

	public void setMaxCapacity(long maxCapacity) {
		this.maxCapacity = maxCapacity;
	}

	public long getMinCapacity() {
		return minCapacity;
	}

	public void setMinCapacity(long minCapacity) {
		this.minCapacity = minCapacity;
	}
	
}
