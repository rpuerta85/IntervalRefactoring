package intervals;

import utils.ExactPoint;
import utils.FromPoint;

public class UnOpened extends Interval{
	protected ExactPoint maximum2;
	protected ExactPoint minimum2;
	
	public UnOpened(double minimum, double maximum, Opening opening) {
		super(minimum, maximum, opening);
		this.minimum2 = new ExactPoint(minimum);
		this.maximum2 = new ExactPoint(maximum);
	}

	
	@Override
	public boolean includes(double value) {
		//return minimum <= value && value <= maximum;
		return minimum2.isLessThan(value) && maximum2.isGreaterThan(value);
	}

	@Override
	public boolean includes(Interval interval) {
		boolean minimumIncluded = this.includes(interval.minimum);
		boolean maximumIncluded = this.includes(interval.maximum);
		switch (interval.opening) {
		case BOTH_OPENED:
			return (minimumIncluded || minimum == interval.minimum)
					&& (maximumIncluded || maximum == interval.maximum);
		case LEFT_OPENED:
			return (minimumIncluded || minimum == interval.minimum)
					&& (maximumIncluded || maximum == interval.maximum);
		case RIGHT_OPENED:
			return (minimumIncluded || minimum == interval.minimum)
					&& (maximumIncluded || maximum == interval.maximum);
		case UNOPENED:
			return (minimumIncluded || minimum == interval.minimum)
					&& (maximumIncluded || maximum == interval.maximum);
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
