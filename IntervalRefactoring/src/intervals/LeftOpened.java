package intervals;

import utils.ExactPoint;
import utils.FromPoint;
import utils.Point;
import utils.UntilPoint;

public class LeftOpened extends Interval {
	//protected Point maximum2;
	//protected Point minimum2;
	
	public LeftOpened(double minimum, double maximum, Opening opening) {
		super(new FromPoint(minimum), new ExactPoint(maximum), opening);
		//this.minimum2 = new FromPoint(minimum);
		//this.maximum2 = new ExactPoint(maximum);
	}

/*	@Override
	public boolean includes(double value) {
		//return minimum < value && value <= maximum;
		return minimum2.isLessThan(value) && maximum2.isGreaterThan(value);
	}*/
	
	@Override
	public boolean includes(Interval interval) {
		boolean minimumIncluded = this.includes(interval.minimum.getValue());
		boolean maximumIncluded = this.includes(interval.maximum.getValue());
		switch (interval.opening) {
		case BOTH_OPENED:
			return (minimumIncluded || minimum == interval.minimum)
					&& (maximumIncluded || maximum == interval.maximum);
		case LEFT_OPENED:
			return (minimumIncluded || minimum == interval.minimum)
					&& (maximumIncluded || maximum == interval.maximum);
		case RIGHT_OPENED:
			return (minimumIncluded)
					&& (maximumIncluded || maximum == interval.maximum);
		case UNOPENED:
			return (minimumIncluded)
					&& (maximumIncluded || maximum == interval.maximum);
		default:
			assert false;
			return false;
		}
	}

	/*@Override
	public boolean intersectsWith(Interval interval) {
		if (minimum == interval.maximum) {
				return false;
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
		return false;
	}

	@Override
	public boolean intersectsWithMaximumEqualsMinimumImplementation(
			Interval interval) {
		return interval.opening == Opening.RIGHT_OPENED ||
				interval.opening == Opening.UNOPENED;
	}

}

