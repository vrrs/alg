package com.vrrs.alg.problems.math;

public class OverlappingRectangleFinder {
	
	private class Point{
		private double x;
		private double y;
	}
	
	public double getOverlappingArea(Point bottomLeft1, Point topRight1, Point bottomLeft2, Point topRight2) {
		if(bottomLeft1.x <= bottomLeft2.x) {
			return getArea(bottomLeft2, topRight2, bottomLeft1, topRight1);
		} else {
			return getArea(bottomLeft1, topRight1, bottomLeft2, topRight2);
		}
	}

	private double getArea(Point bottomLeft1, Point topRight1, Point bottomLeft2, Point topRight2) {
		if(bottomLeft2.y > topRight1.y || bottomLeft1.y > topRight2.y || bottomLeft1.x > topRight2.x)
			return 0;
		double oX1 = bottomLeft1.x;
		double oX2 = Math.min(topRight2.x, topRight1.x);
		double oY1 = Math.max(bottomLeft2.y, bottomLeft1.y);
		double oY2 = Math.min(topRight2.y, topRight1.y);
		return (oY2-oY1)*(oX2-oX1);
	}

}
