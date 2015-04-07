package intervals;


public class IntervalFactory {
	public static Interval getIntervalBothOpened(double minimum, double maximum) {
		return new BothOpened(minimum, maximum);
	}
	public static Interval getIntervalLeftOpened(double minimum, double maximum) {
		return new LeftOpened(minimum, maximum);
	}
	public static Interval getIntervalRightOpened(double minimum, double maximum) {
		return new RightOpened(minimum, maximum);
	}
	public static Interval getIntervalUnOpened(double minimum, double maximum) {
		return new UnOpened(minimum, maximum);
	}
}
