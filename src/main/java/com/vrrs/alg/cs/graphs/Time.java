package com.vrrs.alg.cs.graphs;

public final class Time {
	private final int time;
	private final boolean startTime;
	
	public Time(int time, boolean startTime) {
		this.time = time;
		this.startTime = startTime;
	}
	public int getTime() {
		return time;
	}
	public boolean isStartTime() {
		return startTime;
	}
}