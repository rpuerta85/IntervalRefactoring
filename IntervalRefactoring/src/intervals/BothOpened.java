package intervals;

import utils.FromPoint;
import utils.Point;
import utils.UntilPoint;


public class BothOpened extends Interval{
	protected UntilPoint maximum2;
	protected FromPoint minimum2;
	
	public BothOpened(double minimum, double maximum, Opening opening) {
		super(minimum, maximum, opening);
		this.maximum2 = new UntilPoint(maximum);
		this.minimum2 = new FromPoint(minimum);
	}

	@Override
	public boolean includes(double value) {
		//return minimum < value && value < maximum;
		
		return minimum2.isLessThan(value) && maximum2.isLessThan(value);
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

	@Override
	public boolean intersectsWithMinimunEqualsMaximumImplementation(
			Interval interval) {// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean intersectsWithMaximumEqualsMinimumImplementation(
			Interval interval) {
		return false;
	}

	/*@Override
	public boolean intersectsWith(Interval interval) {
		if (minimum == interval.maximum) {
				return false;
		}
		if (maximum == interval.minimum) {
				return false;
			
		}
		return this.includes(interval.minimum)
				|| this.includes(interval.maximum);
	}*/
	

}
