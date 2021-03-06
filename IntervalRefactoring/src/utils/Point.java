package utils;

import intervals.Interval;

public abstract class Point {
	protected double value;
	
	public Point(double value) {
		this.value = value;
	}

	public abstract boolean isLessThan(double value);
	public abstract boolean isGreaterThan(double value);
	
	public abstract boolean isLessThan(Point value);
	public abstract boolean isGreaterThan(Point value);	
	/*public  boolean isGreaterThan(Point point){
		return point.isLessThan(value);
	}
	public boolean isLessThan(Point point){
		return point.isGreaterThan(value);
	}*/
	
	public boolean isLessThan(ExactPoint point) {
		return point.isGreaterThan(value);
	}
	public boolean isGreaterThan(ExactPoint point) {
		return point.isLessThan(value);
	}
	
	public boolean isLessThan(OpenPoint point) {
		return point.isGreaterThan(value);
	}
	public boolean isGreaterThan(OpenPoint point) {
		return point.isLessThan(value);

	}
	
	public double getValue() {
		return value;
	}

	public void setValue(double value) {
		this.value = value;
	}
	
	public boolean amIIncludeInIntervalMinimum(Interval interval){
		return this.isLessThan(interval.getMinimum().value);

	}
	public boolean amIIncludeInIntervalMaximum(Interval interval){
		return  this.isGreaterThan(interval.getMaximum().value);

	}
}
