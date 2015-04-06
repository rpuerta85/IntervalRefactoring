package intervals;

import utils.ExactPoint;
import utils.FromPoint;
import utils.Point;
import utils.UntilPoint;

public class LeftOpened extends Interval {

	public LeftOpened(double minimum, double maximum, Opening opening) {
		super(new FromPoint(minimum),new ExactPoint(maximum), opening);
	}

	@Override
	public boolean includes(double value) {
		//return minimum < value && value <= maximum;
		return minimum2.isLessThan(value) && maximum2.isGreaterThan(value);
	}
	
	
	
	public boolean amIIncludeInInterval(BothOpened interval) {
		boolean minimumIncluded = interval.includes(minimum2.getValue());
		boolean maximumIncluded = interval.includes(maximum2.getValue());
		return  (minimumIncluded || minimum2.getValue() == interval.minimum2.getValue())
				&& (maximumIncluded);
	}
	
	
	public boolean includes(BothOpened interval) {
		return interval.amIIncludeInInterval(this);
	}
	public boolean includes(RightOpened interval) {
		return interval.amIIncludeInInterval(this);
	}
	public boolean includes(UnOpened interval) {
		return interval.amIIncludeInInterval(this);
	}
	@Override
	public boolean includes(Interval interval) {
		return interval.amIIncludeInInterval(this);
	}
//	@Override
//	public boolean includes(Interval interval) {
//		boolean minimumIncluded = this.includes(interval.minimum2.getValue());
//		boolean maximumIncluded = this.includes(interval.maximum2.getValue());
//		switch (interval.opening) {
//		case BOTH_OPENED:
//			/*return (minimumIncluded || minimum2.getValue() == interval.minimum2.getValue())
//					&& (maximumIncluded || maximum2.getValue() == interval.maximum2.getValue());*/
//			return includesBothOpened(interval);
//		case LEFT_OPENED:
//			return (minimumIncluded || minimum2.getValue() == interval.minimum2.getValue())
//					&& (maximumIncluded || maximum2.getValue() == interval.maximum2.getValue());
//		case RIGHT_OPENED:
//			return (minimumIncluded)
//					&& (maximumIncluded || maximum2.getValue() == interval.maximum2.getValue());
//		case UNOPENED:
//			return (minimumIncluded)
//					&& (maximumIncluded || maximum2.getValue() == interval.maximum2.getValue());
//		default:
//			assert false;
//			return false;
//		}
//	}
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

	@Override
	public boolean amIIncludeInInterval(LeftOpened interval) {
		boolean minimumIncluded = interval.includes(minimum2.getValue());
		boolean maximumIncluded = interval.includes(maximum2.getValue());
		return (minimumIncluded || minimum2.getValue() == interval.minimum2.getValue())
				&& (maximumIncluded || maximum2.getValue() == interval.maximum2.getValue());
	}

	public boolean amIIncludeInInterval(RightOpened interval) {
		boolean minimumIncluded = interval.includes(minimum2.getValue());
		boolean maximumIncluded = interval.includes(maximum2.getValue());
		return (minimumIncluded || minimum2.getValue() == interval.minimum2.getValue())
				&& (maximumIncluded);
	}

	public boolean amIIncludeInInterval(UnOpened interval) {
		boolean minimumIncluded = interval.includes(minimum2.getValue());
		boolean maximumIncluded = interval.includes(maximum2.getValue());
		return (minimumIncluded || minimum2.getValue() == interval.minimum2.getValue())
				&& (maximumIncluded || maximum2.getValue() == interval.maximum2.getValue());
	}



}

