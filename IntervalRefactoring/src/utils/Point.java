package utils;

public abstract class Point {
	protected double value;
	
	public Point(double value) {
		this.value = value;
	}
	
	public abstract boolean isLessThan(double value);
	
	public abstract boolean isGreaterThan(double value);

	public double getValue() {
		return value;
	}

	public void setValue(double value) {
		this.value = value;
	}
	
}
