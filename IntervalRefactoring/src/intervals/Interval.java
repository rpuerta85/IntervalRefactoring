package intervals;

import utils.ExactPoint;
import utils.Point;

public abstract class Interval {

	protected Point maximum;
	protected Point minimum;
	
	protected Opening opening;

	 Interval(Point minimum, Point maximum, Opening opening) {
		this.minimum = minimum;
		this.maximum = maximum;
		this.opening = opening;
		
	}
	 
	public double midPoint() {
		return (maximum.getValue() + minimum.getValue()) / 2;
	}

	public boolean includes(double value) {
		Point point = new ExactPoint(value);
		return minimum.isGreaterThan(point) && maximum.isLessThan(point);
	}

	public  boolean includes(Interval interval){
		return this.minimum.isGreaterThan(interval.getMinimum()) && this.maximum.isLessThan((interval.getMaximum())); 

	}
	
	public boolean intersectsWith(Interval interval){
		if (minimum.getValue() == interval.maximum.getValue()) {
			return intersectsWithMinimunEqualsMaximumImplementation(interval);
		}
		if (maximum.getValue() == interval.minimum.getValue()) {
			return intersectsWithMaximumEqualsMinimumImplementation(interval);
		
		}
		return this.includes(interval.minimum.getValue())
			|| this.includes(interval.maximum.getValue());
		}	
	
	public abstract boolean intersectsWithMinimunEqualsMaximumImplementation(Interval interval);
	public abstract boolean intersectsWithMaximumEqualsMinimumImplementation(Interval interval);

	@Override
	public String toString() {
		// TODO
		return null;
	}

	@Override
	public boolean equals(Object object) {
		// TODO
		return false;
	}

	public Point getMaximum() {
		return maximum;
	}

	public Point getMinimum() {
		return minimum;
	}

}
