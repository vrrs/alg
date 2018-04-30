package com.vrrs.alg.cs.graphs;

public final class Interval {
	
	private int startTime;
	private int endTime;
	
	public Interval(int startTime, int endTime) {
		this.startTime = startTime;
		this.endTime = endTime;
	}
	public Interval() {
		this(0, 0);
	}
	
	public int getStartTime() {
		return startTime;
	}
	public void setStartTime(int startTime) {
		this.startTime = startTime;
	}
	public int getEndTime() {
		return endTime;
	}
	public void setEndTime(int endTime) {
		this.endTime = endTime;
	}
	
	
	

}
