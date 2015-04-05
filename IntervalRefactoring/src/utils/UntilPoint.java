package utils;


public class UntilPoint extends Point {

	public UntilPoint(double value) {
		super(value);
	}

	@Override
	public boolean isLessThan(double value) {
		System.out.println(value+":"+(value < this.value));
		return value < this.value;
	}

	@Override
	public boolean isGreaterThan(double value) {
		return value > this.value;
	}

}
