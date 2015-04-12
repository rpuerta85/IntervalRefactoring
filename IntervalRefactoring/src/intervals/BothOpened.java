package intervals;

import utils.OpenPoint;


public class BothOpened extends Interval{
	private static final Opening TYPE = Opening.BOTH_OPENED;
	public BothOpened(double minimum, double maximum) {
		super(new OpenPoint(minimum), new OpenPoint(maximum), TYPE);
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

}
