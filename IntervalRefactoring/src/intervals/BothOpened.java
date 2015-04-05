package intervals;

public class BothOpened extends Interval{
	
	public BothOpened(double minimum, double maximum, Opening opening) {
		super(minimum, maximum, opening);
	}

	@Override
	public boolean includes(double value) {
		return minimum < value && value < maximum;
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
							&& (maximumIncluded);
				case RIGHT_OPENED:
					return (minimumIncluded)
							&& (maximumIncluded || maximum == interval.maximum);
				case UNOPENED:
					return (minimumIncluded) && (maximumIncluded);
				default:
					assert false;
					return false;
				}
		
			
		}
	

}
