package intervals;

public class RightOpened extends Interval {

	public RightOpened(double minimum, double maximum, Opening opening) {
		super(minimum, maximum, opening);
	}

	@Override
	public boolean includes(double value) {
		return minimum <= value && value < maximum;
	}

}