package intervals;

public class LeftOpened extends Interval {

	public LeftOpened(double minimum, double maximum, Opening opening) {
		super(minimum, maximum, opening);
	}

	@Override
	public boolean includes(double value) {
		return minimum < value && value <= maximum;
	}

}
