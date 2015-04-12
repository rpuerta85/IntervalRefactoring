package intervals;

import utils.ExactPoint;
import utils.OpenPoint;

public class RightOpened extends Interval {
	private static final Opening TYPE = Opening.RIGHT_OPENED;
	
	public RightOpened(double minimum, double maximum) {
		super(new ExactPoint(minimum), new OpenPoint(maximum), TYPE);
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
