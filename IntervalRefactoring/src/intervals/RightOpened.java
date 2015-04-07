package intervals;

import utils.ExactPoint;
import utils.OpenPoint;

public class RightOpened extends Interval {
	private static final Opening TYPE = Opening.RIGHT_OPENED;
	
	public RightOpened(double minimum, double maximum) {
		super(new ExactPoint(minimum), new OpenPoint(maximum), TYPE);
	}	
	
	@Override
	public boolean amIIncludeInInterval(RightOpened interval) {
		boolean minimumIncluded = interval.includes(minimum.getValue());
		boolean maximumIncluded = interval.includes(maximum.getValue());
		return (minimumIncluded || minimum.getValue() == interval.minimum.getValue())
				&& (maximumIncluded || maximum.getValue() == interval.maximum.getValue());
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
		boolean minimumIncluded = interval.includes(minimum.getValue());
		boolean maximumIncluded = interval.includes(maximum.getValue());
		return  (minimumIncluded)
				&& (maximumIncluded || maximum.getValue() == interval.maximum.getValue());
		
	}
	@Override
	public boolean amIIncludeInInterval(LeftOpened interval) {
		boolean minimumIncluded = interval.includes(minimum.getValue());
		boolean maximumIncluded = interval.includes(maximum.getValue());
		return (minimumIncluded)
				&& (maximumIncluded || maximum.getValue() == interval.maximum.getValue());
			}
	@Override
	public boolean amIIncludeInInterval(UnOpened interval) {
		boolean minimumIncluded = interval.includes(minimum.getValue());
		boolean maximumIncluded = interval.includes(maximum.getValue());
		return (minimumIncluded || minimum.getValue() == interval.minimum.getValue())
				&& (maximumIncluded || maximum.getValue() == interval.maximum.getValue());
	}


	

}
