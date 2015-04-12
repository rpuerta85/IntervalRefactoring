package intervals;

import utils.ExactPoint;


public class UnOpened extends Interval{
	private static final Opening TYPE = Opening.UNOPENED;
	public UnOpened(double minimum, double maximum) {
		super(new ExactPoint(minimum), new ExactPoint(maximum), TYPE);
	}
	
	public boolean amIIncludeInInterval(UnOpened interval) {
		boolean minimumIncluded = interval.includes(minimum.getValue());
		boolean maximumIncluded = interval.includes(maximum.getValue());
		return (minimumIncluded || minimum.getValue() == interval.minimum.getValue())
				&& (maximumIncluded || maximum.getValue() == interval.maximum.getValue());
	}

	@Override
	public boolean intersectsWithMinimunEqualsMaximumImplementation(
			Interval interval) {
		return interval.opening == Opening.LEFT_OPENED ||
				interval.opening == Opening.UNOPENED;
	}

	@Override
	public boolean intersectsWithMaximumEqualsMinimumImplementation(
			Interval interval) {
		return interval.opening == Opening.RIGHT_OPENED ||
				interval.opening == Opening.UNOPENED;
	}
}
