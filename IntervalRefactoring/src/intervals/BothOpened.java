package intervals;

import utils.OpenPoint;


public class BothOpened extends Interval{
	private static final Opening TYPE = Opening.BOTH_OPENED;
	public BothOpened(double minimum, double maximum) {
		super(new OpenPoint(minimum), new OpenPoint(maximum), TYPE);
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
		return false;
	}

	@Override
	public boolean amIIncludeInInterval(BothOpened interval) {
		return interval.includesBothOpened(this);
	}
	@Override
	public boolean amIIncludeInInterval(LeftOpened interval) {
		return interval.includesBothOpened(this);
	}
	@Override
	public boolean amIIncludeInInterval(RightOpened interval) {
		return interval.includesBothOpened(this);
	}
	@Override
	public boolean amIIncludeInInterval(UnOpened interval) {
		return interval.includesBothOpened(this);
	}



	
	
}
