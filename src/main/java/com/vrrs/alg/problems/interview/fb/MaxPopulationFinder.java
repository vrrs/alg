package com.vrrs.alg.problems.interview.fb;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import com.vrrs.alg.cs.graphs.Interval;
import com.vrrs.alg.cs.graphs.Time;

public class MaxPopulationFinder {
	
	private static final Comparator<Time> TIME_CMP = (time1, time2) -> {
		if(time1.getTime() == time2.getTime()) {
			if(time1.isStartTime() && time2.isStartTime() 
					|| !time1.isStartTime() && !time2.isStartTime()) {
				return 0;
			} else {
				return time1.isStartTime() && !time2.isStartTime() ? 1 : -1;
			}
		} else {
			return time1.getTime() < time2.getTime() ? -1 : 1;
		}
	};
	
	public int find(List<Interval> peopleLifeSpans) {
		List<Time> times = getTimes(peopleLifeSpans);
		Collections.sort(times, TIME_CMP);
		int maxYear = 0;
		int maxNumOfPeopleAlived = 0;
		int numOfDeadPeople = 0, numOfBornedPeople = 0;
		for(Time time : times) {
			if(time.isStartTime()) {
				numOfBornedPeople++;
				int numOfAlivedPeople = numOfBornedPeople - numOfDeadPeople;
				if(numOfAlivedPeople > maxNumOfPeopleAlived) {
					maxNumOfPeopleAlived = numOfAlivedPeople;
					maxYear = time.getTime();
				}
			} else {
				numOfDeadPeople++;
			}
		}
		return maxYear;
	}

	private List<Time> getTimes(List<Interval> peopleLifeSpans) {
		List<Time> times = new ArrayList<>();
		for(Interval span : peopleLifeSpans) {
			times.add(new Time(span.getStartTime(), true));
			times.add(new Time(span.getEndTime(), false));
		}
		return times;
	}

}
