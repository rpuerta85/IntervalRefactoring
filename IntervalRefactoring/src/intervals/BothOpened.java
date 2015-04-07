package intervals;

import utils.OpenPoint;


public class BothOpened extends Interval{
	private static final Opening TYPE = Opening.BOTH_OPENED;
	public BothOpened(double minimum, double maximum) {
		//super(new FromPoint(minimum), new UntilPoint(maximum), opening);
		super(new OpenPoint(minimum), new OpenPoint(maximum), TYPE);
	}

	//Doble despacho
	public boolean includes(LeftOpened interval) {
		return interval.amIIncludeInInterval(this);
	}
	public boolean includes(RightOpened interval) {
		return interval.amIIncludeInInterval(this);
	}
	public boolean includes(UnOpened interval) {
		return interval.amIIncludeInInterval(this);
	}
	
	@Override
	public boolean includes(Interval interval) {
		return interval.amIIncludeInInterval(this);
	}
	
	
//	@Override
//	public boolean includes(Interval interval) {
//			switch (interval.opening) {
//				case BOTH_OPENED:
//					return includesBothOpened(interval);
//				case LEFT_OPENED:
//					return includes((LeftOpened)interval);
//				case RIGHT_OPENED:
//					return /*(minimumIncluded)
//							&& (maximumIncluded || maximum2.getValue() == interval.maximum2.getValue())*/
//							includes((RightOpened)interval);
//				case UNOPENED:
//					return /*(minimumIncluded) && (maximumIncluded)*/includes((UnOpened)interval);
//				default:
//					assert false;
//					return false;
//				}
//		
//			
//		}

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
