package intervals;

public class UnOpened extends Interval{

	public UnOpened(double minimum, double maximum, Opening opening) {
		super(minimum, maximum, opening);
	}

	@Override
	public boolean includes(double value) {
		return minimum <= value && value <= maximum;
	}
	
	
	

}
