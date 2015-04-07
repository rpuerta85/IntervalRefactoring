package intervals;

import utils.ExactPoint;


public class UnOpened extends Interval{
	private static final Opening TYPE = Opening.UNOPENED;
	public UnOpened(double minimum, double maximum) {
		super(new ExactPoint(minimum), new ExactPoint(maximum), TYPE);
	}
	@Override
	public boolean includes(double value) {
		//return minimum <= value && value <= maximum;
		return minimum2.isLessThan(value) && maximum2.isGreaterThan(value);
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
	public boolean amIIncludeInInterval(UnOpened interval) {
		boolean minimumIncluded = interval.includes(minimum2.getValue());
		boolean maximumIncluded = interval.includes(maximum2.getValue());
		return (minimumIncluded || minimum2.getValue() == interval.minimum2.getValue())
				&& (maximumIncluded || maximum2.getValue() == interval.maximum2.getValue());
	}
	public boolean includes(LeftOpened interval) {
		return interval.amIIncludeInInterval(this);
	}
	
	
	@Override
	public boolean includes(Interval interval) {
		return interval.amIIncludeInInterval(this);
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
	public boolean amIIncludeInInterval(RightOpened interval) {
		boolean minimumIncluded = interval.includes(minimum2.getValue());
		boolean maximumIncluded = interval.includes(maximum2.getValue());
		return (minimumIncluded || minimum2.getValue() == interval.minimum2.getValue())
				&& (maximumIncluded);
	}

	
	

}
