package com.vrrs.alg.problems.codejam2018.qualification.cubicufo;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public final class Solution {
	
	private static final double RADIUS = 0.5;

	public List<String> solve(double area) {
		List<String> points = new ArrayList<String>();
		double theta = getRotationAngle(area);
		points.add(getPoint1AsString(theta));
		points.add(getPoint2AsString(theta));
		points.add(getPoint3AsString(theta));
		return points;
	}
	
	private String getPoint3AsString(double theta) {
		return getPointAsString(0, 0, RADIUS);
	}

	private String getPoint2AsString(double theta) {
		double x = -1*RADIUS*Math.sin(theta);
		double y = RADIUS*Math.cos(theta);
		return getPointAsString(x, y, 0);
	}

	private String getPoint1AsString(double theta) {
		double x = RADIUS*Math.cos(theta);
		double y = RADIUS*Math.sin(theta);
		return getPointAsString(x, y, 0);
	}
	
	private String getPointAsString(double x, double y, double z) {
		return String.valueOf(x) + " " + String.valueOf(y) 
			+ " " +String.valueOf(z);
	}

	private double getRotationAngle(double area) {
		return 0.5*Math.asin(area*area - 1); 
	}

	public static void main(String[] s) {
		Solution solver = new Solution();
		Scanner reader = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
	    int numOfTestCases = reader.nextInt();
	    for (int i = 1; i <= numOfTestCases; i++) {
	      double area = reader.nextDouble();
	      System.out.println("Case #" + i + ":");
	      solver.solve(area).stream().forEach(System.out::println);
	    }
	    reader.close();
	}
}
