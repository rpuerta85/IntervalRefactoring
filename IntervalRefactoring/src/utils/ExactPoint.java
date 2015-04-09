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
	public boolean amIIncludeInInterval(Interval interval){
		return (this.isLessThan(interval.getMinimum().value) &&   this.isLessThan(interval.getMaximum().value));
	}
}
