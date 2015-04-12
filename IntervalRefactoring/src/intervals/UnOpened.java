package intervals;

import utils.ExactPoint;


public class UnOpened extends Interval{
	private static final Opening TYPE = Opening.UNOPENED;
	public UnOpened(double minimum, double maximum) {
		super(new ExactPoint(minimum), new ExactPoint(maximum), TYPE);
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
