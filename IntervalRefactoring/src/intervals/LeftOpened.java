package intervals;

import utils.ExactPoint;
import utils.OpenPoint;

public class LeftOpened extends Interval {

	private static final Opening TYPE = Opening.LEFT_OPENED;
	
	public LeftOpened(double minimum, double maximum) {
		super(new OpenPoint(minimum),new ExactPoint(maximum), TYPE);
	}
	
	@Override
	public boolean includes(Interval interval) {
		return interval.amIIncludeInInterval(this);
	}
	
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
	@Override
	public boolean amIIncludeInInterval(RightOpened interval) {
		boolean minimumIncluded = interval.includes(minimum2.getValue());
		boolean maximumIncluded = interval.includes(maximum2.getValue());
		return (minimumIncluded || minimum2.getValue() == interval.minimum2.getValue())
				&& (maximumIncluded);
	}
	@Override
	public boolean amIIncludeInInterval(UnOpened interval) {
		boolean minimumIncluded = interval.includes(minimum2.getValue());
		boolean maximumIncluded = interval.includes(maximum2.getValue());
		return (minimumIncluded || minimum2.getValue() == interval.minimum2.getValue())
				&& (maximumIncluded || maximum2.getValue() == interval.maximum2.getValue());
	}
	@Override
	public boolean amIIncludeInInterval(BothOpened interval) {
		boolean minimumIncluded = interval.includes(minimum2.getValue());
		boolean maximumIncluded = interval.includes(maximum2.getValue());
		return  (minimumIncluded || minimum2.getValue() == interval.minimum2.getValue())
				&& (maximumIncluded);
	}







	






}

