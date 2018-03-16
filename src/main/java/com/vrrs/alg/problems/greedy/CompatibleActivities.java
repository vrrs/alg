package com.vrrs.alg.problems.greedy;

import java.util.Comparator;
import java.util.NavigableSet;
import java.util.TreeSet;
import com.vrrs.alg.problems.greedy.CompatibleActivities.ActivityComparator.Time;

/**
 * Given a collection of activities with start and end time, find the optimal schedule that maximize the # of compatible activities. 
 * @author victor regalado
 */
public class CompatibleActivities {
	private Activity[] activities;
	public CompatibleActivities(int[] startTime, int[] endTimes){
		activities = new Activity[startTime.length];
		for(int i = 0; i < startTime.length; i++){
			activities[i] = new Activity(startTime[i], endTimes[i]);
		}
	}
	
	static class ActivityComparator implements Comparator<Activity> {
		private Time criteria;
		private ActivityComparator(Time criteria){
			this.criteria = criteria;
		}
		
		public enum Time {
			START_TIME, END_TIME
		}
		
		public static Comparator<Activity> by(Time criteria){
			return new ActivityComparator(criteria);
		}
		@Override
		public int compare(Activity a1, Activity a2) {
			int time1 = getTime(a1);
			int time2 = getTime(a2);
			if (time1 == time2)	return 0;
			if(time1 < time2)	return -1; else return 1;
		}
		private int getTime(Activity activity){
			return criteria.equals(Time.START_TIME) 	?	activity.startTime	:	activity.endTime;
		}
	 }
	
	 static class Activity {
		int startTime;
		int endTime;
		Activity(int startTime, int endTime){
			this.startTime = startTime;
			this.endTime = endTime;
		}
		public String toString(){
			return "[" + startTime + "-" + endTime + "]";
		}
	}
	
	public String printOptimalSchedule(){
		StringBuilder buff = new StringBuilder();
		Activity prev = firstActivityByFinalTime();
		NavigableSet<Activity> activitiesByStartTime = activitiesByStartTime();
		do{
			buff.append(prev).append(",");
			prev = activitiesByStartTime.ceiling(swapTimes(prev));
		}while(prev!=null);
		return buff.toString();
	}
	
	private Activity swapTimes(Activity activity) {
		return new Activity(activity.endTime, activity.startTime);
	}

	private NavigableSet<Activity> activitiesByStartTime() {
		NavigableSet<Activity> activitiesByStartTime = new TreeSet<Activity>(ActivityComparator.by(Time.START_TIME));
		for(Activity activity : activities)	activitiesByStartTime.add(activity);
		return activitiesByStartTime;
	}

	private Activity firstActivityByFinalTime(){
		Activity first = activities[0];
		for(Activity activity : activities)	
			if(activity.endTime < first.endTime)	first = activity;
		return first;
	}
	
	
}
