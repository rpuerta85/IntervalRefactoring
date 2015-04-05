package utils;


public class UntilPoint extends Point {

	public UntilPoint(double value) {
		super(value);
	}

	@Override
	public boolean isLessThan(double value) {
		return value < this.value;
	}

	@Override
	public boolean isGreaterThan(double value) {
		return value > this.value;
	}

}
