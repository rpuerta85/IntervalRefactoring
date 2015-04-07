 package utils;


public class FromPoint extends Point {

	public FromPoint(double value) {
		super(value);
	}

	@Override
	public boolean isLessThan(double value) {
		return this.value < value;
	}

	@Override
	public boolean isGreaterThan(double value) {
		return this.value > value;

	}

}
