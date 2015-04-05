package intervals;

public class LeftOpened extends Interval {

	public LeftOpened(double minimum, double maximum, Opening opening) {
		super(minimum, maximum, opening);
	}

	@Override
	public boolean includes(double value) {
		return minimum < value && value <= maximum;
	}

	@Override
	public boolean includes(Interval interval) {
		boolean minimumIncluded = this.includes(interval.minimum);
		boolean maximumIncluded = this.includes(interval.maximum);
		switch (interval.opening) {
		case BOTH_OPENED:
			return (minimumIncluded || minimum == interval.minimum)
					&& (maximumIncluded || maximum == interval.maximum);
		case LEFT_OPENED:
			return (minimumIncluded || minimum == interval.minimum)
					&& (maximumIncluded || maximum == interval.maximum);
		case RIGHT_OPENED:
			return (minimumIncluded)
					&& (maximumIncluded || maximum == interval.maximum);
		case UNOPENED:
			return (minimumIncluded)
					&& (maximumIncluded || maximum == interval.maximum);
		default:
			assert false;
			return false;
		}
	}

	@Override
	public boolean intersectsWith(Interval interval) {
		if (minimum == interval.maximum) {
				return false;
		}
		if (maximum == interval.minimum) {
			return interval.opening == Opening.RIGHT_OPENED ||
					interval.opening == Opening.UNOPENED;
			
		}
		return this.includes(interval.minimum)
				|| this.includes(interval.maximum);
	}

}

