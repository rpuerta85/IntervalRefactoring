package utils;

public class Point {
	protected double value;
	
	public Point(double value) {
		this.value = value;
	}
	
	public boolean isLessThan(double value) {
		return this.value < value;
	}
	public boolean isLessOrEqualsThan(double value) {
		return this.value <= value;
	}
	
	public boolean isGreaterThan(double value) {
		return this.value > value;
	}
}
