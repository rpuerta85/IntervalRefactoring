package intervals;

import utils.ExactPoint;
import utils.FromPoint;
import utils.Point;

public class UnOpened extends Interval{
	//protected Point maximum2;
	//protected Point minimum2;
	
	public UnOpened(double minimum, double maximum, Opening opening) {
		super(new ExactPoint(minimum), new ExactPoint(maximum), opening);
		//this.minimum2 = new ExactPoint(minimum);
		//this.maximum2 = new ExactPoint(maximum);
	}
/**	public UnOpened(double minimum, double maximum, Opening opening) {
		super(new ExactPoint(minimum), new ExactPoint(maximum), opening);
		//this.minimum2 = new ExactPoint(minimum);
		//this.maximum2 = new ExactPoint(maximum);
	}*/

	
	@Override
	public boolean includes(double value) {
		//return minimum <= value && value <= maximum;
		return minimum2.isLessThan(value) && maximum2.isGreaterThan(value);
	}

	@Override
	public boolean includes(Interval interval) {
		boolean minimumIncluded = this.includes(interval.minimum2.getValue());
		boolean maximumIncluded = this.includes(interval.maximum2.getValue());
		switch (interval.opening) {
		case BOTH_OPENED:
			return (minimumIncluded || minimum2.getValue() == interval.minimum2.getValue())
					&& (maximumIncluded || maximum2.getValue() == interval.maximum2.getValue());
		case LEFT_OPENED:
			return (minimumIncluded || minimum2.getValue() == interval.minimum2.getValue())
					&& (maximumIncluded || maximum2.getValue() == interval.maximum2.getValue());
		case RIGHT_OPENED:
			return (minimumIncluded || minimum2.getValue() == interval.minimum2.getValue())
					&& (maximumIncluded || maximum2.getValue() == interval.maximum2.getValue());
		case UNOPENED:
			return (minimumIncluded || minimum2.getValue() == interval.minimum2.getValue())
					&& (maximumIncluded || maximum2.getValue() == interval.maximum2.getValue());
		default:
			assert false;
			return false;
		}
	}

	/*@Override
	public boolean intersectsWith(Interval interval) {
		if (minimum == interval.maximum) {
			return interval.opening == Opening.LEFT_OPENED ||
						interval.opening == Opening.UNOPENED;
		}
		if (maximum == interval.minimum) {
				return interval.opening == Opening.RIGHT_OPENED ||
						interval.opening == Opening.UNOPENED;
		}
		return this.includes(interval.minimum)
				|| this.includes(interval.maximum);

	}*/

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
