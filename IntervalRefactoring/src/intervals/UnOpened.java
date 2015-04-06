package intervals;

import utils.ExactPoint;


public class UnOpened extends Interval{
	
	public UnOpened(double minimum, double maximum, Opening opening) {
		super(new ExactPoint(minimum), new ExactPoint(maximum), opening);
	}
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
			/*return (minimumIncluded || minimum2.getValue() == interval.minimum2.getValue())
					&& (maximumIncluded || maximum2.getValue() == interval.maximum2.getValue());*/
			return includesBothOpened(interval);
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
	public boolean amIIncludeInInterval(BothOpened interval) {
		boolean minimumIncluded = interval.includes(minimum2.getValue());
		boolean maximumIncluded = interval.includes(maximum2.getValue());
		return  (minimumIncluded) && (maximumIncluded);
	}
	public boolean amIIncludeInInterval(LeftOpened interval) {
		boolean minimumIncluded = interval.includes(minimum2.getValue());
		boolean maximumIncluded = interval.includes(maximum2.getValue());
		return (minimumIncluded)
				&& (maximumIncluded || maximum2.getValue() == interval.maximum2.getValue());
		
		//return interval.includesBothOpened(this);

	}

	
	

}
