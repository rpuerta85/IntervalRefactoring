package utils;


public class UntilPoint extends Point {

	public UntilPoint(double value) {
		super(value);
	}

	@Override
	public boolean isLessThan(double value) {
		//return value < this.value;
		return this.value < value;
	}

	@Override
	public boolean isGreaterThan(double value) {
		return this.value > value;
	}

}
