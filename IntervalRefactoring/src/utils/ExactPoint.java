package utils;

import intervals.Interval;

public class ExactPoint extends Point {

	public ExactPoint(double value) {
		super(value);
	}

	@Override
	public boolean isLessThan(double value) {
		return this.value <= value;
	}

	@Override
	public boolean isGreaterThan(double value) {
		return this.value >= value;
	}
	
	@Override
	public boolean isLessThan(Point point) {
		return point.isLessThan(this); 
	}

	@Override
	public boolean isGreaterThan(Point point) {
		return point.isGreaterThan(this); 
	}
	

	
}
