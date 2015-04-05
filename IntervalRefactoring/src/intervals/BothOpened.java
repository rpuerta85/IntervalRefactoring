package intervals;

import utils.FromPoint;
import utils.Point;
import utils.UntilPoint;


public class BothOpened extends Interval{
	//protected Point maximum2;
	//protected Point minimum2;
	
	/*public BothOpened(double minimum, double maximum, Opening opening) {
		super(new FromPoint(minimum), new UntilPoint(maximum), opening);
		this.maximum2 = new UntilPoint(maximum);
		this.minimum2 = new FromPoint(minimum);
	}*/
	public BothOpened(double minimum, double maximum, Opening opening) {
		super(new FromPoint(minimum), new UntilPoint(maximum), opening);
		//this.maximum2 = new UntilPoint(maximum);
		//this.minimum2 = new FromPoint(minimum);
	}
	
	/*@Override
	public boolean includes(double value) {
		return minimum2.isLessThan(value) && maximum2.isGreaterThan(value);
	}*/

	@Override
	public boolean includes(Interval interval) {
			boolean minimumIncluded = this.includes(interval.minimum2.getValue());
			boolean maximumIncluded = this.includes(interval.maximum2.getValue());
			switch (interval.opening) {
				case BOTH_OPENED:
					return (minimumIncluded || minimum2.getValue() == interval.minimum2.getValue())
							&& (maximumIncluded || maximum2.getValue() == interval.maximum2.getValue());
				case LEFT_OPENED:
					return (minimumIncluded || minimum2.getValue() == interval.minimum2.getValue())
							&& (maximumIncluded);
				case RIGHT_OPENED:
					return (minimumIncluded)
							&& (maximumIncluded || maximum2.getValue() == interval.maximum2.getValue());
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
