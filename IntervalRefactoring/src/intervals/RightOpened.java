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

	public boolean includes(BothOpened interval) {
		return interval.amIIncludeInInterval(this);
	}
	public boolean includes(LeftOpened interval) {
		return interval.amIIncludeInInterval(this);
	}
	public boolean includes(UnOpened interval) {
		return interval.amIIncludeInInterval(this);
	}
	public boolean includes(RightOpened interval) {
		return interval.amIIncludeInInterval(this);
	}
	
	@Override
	public boolean amIIncludeInInterval(RightOpened interval) {
		boolean minimumIncluded = interval.includes(minimum2.getValue());
		boolean maximumIncluded = interval.includes(maximum2.getValue());
		return (minimumIncluded || minimum2.getValue() == interval.minimum2.getValue())
				&& (maximumIncluded || maximum2.getValue() == interval.maximum2.getValue());
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
		return false;
	}
	@Override
	public boolean amIIncludeInInterval(BothOpened interval) {
		boolean minimumIncluded = interval.includes(minimum2.getValue());
		boolean maximumIncluded = interval.includes(maximum2.getValue());
		return  (minimumIncluded)
				&& (maximumIncluded || maximum2.getValue() == interval.maximum2.getValue());
		
	}
	@Override
	public boolean amIIncludeInInterval(LeftOpened interval) {
		boolean minimumIncluded = interval.includes(minimum2.getValue());
		boolean maximumIncluded = interval.includes(maximum2.getValue());
		
		//return amIIncludeInIntervalTemplateMethod(interval);
		
		return (minimumIncluded)
				&& (maximumIncluded || maximum2.getValue() == interval.maximum2.getValue());
		//return interval.includesBothOpened(this);
		
		
	}
	@Override
	public boolean amIIncludeInInterval(UnOpened interval) {
		boolean minimumIncluded = interval.includes(minimum2.getValue());
		boolean maximumIncluded = interval.includes(maximum2.getValue());
		return (minimumIncluded || minimum2.getValue() == interval.minimum2.getValue())
				&& (maximumIncluded || maximum2.getValue() == interval.maximum2.getValue());
	}


	

}
