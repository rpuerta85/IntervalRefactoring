package intervals;

import utils.FromPoint;
import utils.UntilPoint;


public class BothOpened extends Interval{

	public BothOpened(double minimum, double maximum, Opening opening) {
		super(new FromPoint(minimum), new UntilPoint(maximum), opening);
	}
	// hay que hacer doble despacho creo para los que difieren

	
	@Override
	public boolean includes(Interval interval) {// hay que hacer doble despacho creo
			boolean minimumIncluded = this.includes(interval.minimum2.getValue());
			boolean maximumIncluded = this.includes(interval.maximum2.getValue());
			switch (interval.opening) {
				case BOTH_OPENED:
					/*return (minimumIncluded || minimum2.getValue() == interval.minimum2.getValue())
							&& (maximumIncluded || maximum2.getValue() == interval.maximum2.getValue());*/
					return includesBothOpened(interval);
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
}
