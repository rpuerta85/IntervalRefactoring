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
		
	public boolean isLessThan(ExactPoint point) {
		return this.value <= point.getValue();
	}
	public boolean isGreaterThan(ExactPoint point) {
		return this.value >= point.getValue();
	}
	
	public abstract boolean isGreaterThan(Point value);

	
	/*public abstract boolean isLessThan(ExactPoint point);
	public  abstract boolean isGreaterThan(ExactPoint point);*/
	public abstract boolean isLessThan(OpenPoint point);
	public abstract boolean isGreaterThan(OpenPoint point);
	
	public double getValue() {
		return value;
	}

	public void setValue(double value) {
		this.value = value;
	}
	
	public boolean amIIncludeInIntervalMinimum(Interval interval){
		return this.isLessThan(interval.getMinimum().value);// &&   this.isGreaterThan(interval.getMaximum().value));
		//return interval.getMinimum().isLessThan(value) &&   interval.getMinimum().isGreaterThan(value);

	}
	public boolean amIIncludeInIntervalMaximum(Interval interval){
		return  this.isGreaterThan(interval.getMaximum().value);
		//return interval.getMinimum().isLessThan(value) &&   interval.getMinimum().isGreaterThan(value);

	}
}
