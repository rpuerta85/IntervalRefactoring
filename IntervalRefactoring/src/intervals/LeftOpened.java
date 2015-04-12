package intervals;

import utils.ExactPoint;
import utils.OpenPoint;

public class LeftOpened extends Interval {

	private static final Opening TYPE = Opening.LEFT_OPENED;
	
	public LeftOpened(double minimum, double maximum) {
		super(new OpenPoint(minimum),new ExactPoint(maximum), TYPE);
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

}

