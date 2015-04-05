package intervals;


public class IntervalFactory {
	public static Interval getIntervalBothOpened(double minimum, double maximum, Opening opening) {
		return new BothOpened(minimum, maximum, opening);
	}
	public static Interval getIntervalLeftOpened(double minimum, double maximum, Opening opening) {
		return new LeftOpened(minimum, maximum, opening);
	}
	public static Interval getIntervalRightOpened(double minimum, double maximum, Opening opening) {
		return new RightOpened(minimum, maximum, opening);
	}
	public static Interval getIntervalUnOpened(double minimum, double maximum, Opening opening) {
		return new UnOpened(minimum, maximum, opening);
	}
}
