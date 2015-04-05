package intervals;

import utils.ExactPoint;
import utils.FromPoint;
import utils.Point;

public class RightOpened extends Interval {
	public RightOpened(double minimum, double maximum, Opening opening) {
		super(new ExactPoint(minimum), new FromPoint(maximum), opening);
	}	
	
	@Override
	public boolean includes(double value) {
		//return minimum <= value && value < maximum;
		return minimum2.isLessThan(value) && maximum2.isGreaterThan(value);

	}

	@Override
	public boolean includes(Interval interval) {
		boolean minimumIncluded = this.includes(interval.minimum2.getValue());
		boolean maximumIncluded = this.includes(interval.maximum2.getValue());
		switch (interval.opening) {
		case BOTH_OPENED:
			/*return (minimumIncluded || minimum2.getValue() == interval.minimum2.getValue())
					&& (maximumIncluded || maximum2.getValue() == interval.maximum2.getValue());*/
			return includesBothOpened(interval);
		case LEFT_OPENED:
			return (minimumIncluded || minimum2.getValue() == interval.minimum2.getValue())
					&& (maximumIncluded);
		case RIGHT_OPENED:
			return (minimumIncluded || minimum2.getValue() == interval.minimum2.getValue())
					&& (maximumIncluded || maximum2.getValue() == interval.maximum2.getValue());
		case UNOPENED:
			return (minimumIncluded || minimum2.getValue() == interval.minimum2.getValue())
					&& (maximumIncluded);
		default:
			assert false;
			return false;
		}
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
		return false;
	}
	

}
