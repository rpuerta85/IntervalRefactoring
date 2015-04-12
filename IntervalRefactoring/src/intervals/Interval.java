package intervals;

import utils.Point;

public abstract class Interval {

	protected Point maximum;
	protected Point minimum;
	
	protected Opening opening;

	 Interval(Point minimum, Point maximum, Opening opening) {
		this.minimum = minimum;
		this.maximum = maximum;
		this.opening = opening;
		
	}
	 
	public double midPoint() {
		return (maximum.getValue() + minimum.getValue()) / 2;
	}

	public boolean includes(double value) {
		//System.out.println(minimum.isLessThan(value));
		return minimum.isLessThan(value) && maximum.isGreaterThan(value);
	}
	public boolean includes(Point point) {
		return minimum.isLessThan(point.getValue()) && maximum.isGreaterThan(point.getValue());
	}

	
	//public abstract boolean includes(Interval interval);
	
	public  boolean includes(Interval interval){
		//System.out.println(interval.getMinimum().amIIncludeInInterval(this));
		//System.out.println(interval.getMinimum().amIIncludeInInterval(this));
		//System.out.println(interval.includes(this.minimum.getValue()));
	//System.out.println(this.includes(interval.getMinimum().getValue()));
		//return this.minimum.amIIncludeInIntervalMinimum(interval) && this.maximum.amIIncludeInIntervalMaximum(interval); //&& this.maximum.amIIncludeInInterval(interval);
		//return interval.includes(this.minimum.getValue()) && interval.includes(this.maximum.getValue());
		//return interval.getMinimum().amIIncludeInInterval(this) && interval.getMaximum().amIIncludeInInterval(this);
	//eturn this.includes(interval.getMinimum()) && this.includes(interval.getMaximum());
	return this.minimum.isGreaterThan(interval.getMinimum()) && this.maximum.isLessThan((interval.getMaximum())); 
	//return interval.getMinimum().isLessThan(this.minimum) && this.maximum.isGreaterThan((interval.getMaximum())); 

	}

	/*public abstract boolean amIIncludeInInterval(BothOpened bothOpened);
	public abstract boolean amIIncludeInInterval(LeftOpened leftOpened) ;
	public abstract boolean amIIncludeInInterval(RightOpened rightOpened);
	public abstract boolean amIIncludeInInterval(UnOpened unOpened);
	*/
	
	
	
	//hacer un template de este metodo supondria añadir a las clases hijas 4*2=8 metodos nuevos
	//para poder mapear por parametro cada clase hija o en su defecto si el template lo hacemos mediante
	//una condicion supondría añadir 4 metodos mas a las clases hijas, luego creo que no ganamos nada.
	//Por tanto dado que no logro mejorar lo ya existente prefiero dejarlo tal y como esta.
	/*public  boolean amIIncludeInIntervalTemplateMethod(Interval interval) {
		boolean minimumIncluded = interval.includes(minimum2.getValue());
		boolean maximumIncluded = interval.includes(maximum2.getValue());
		return (minimumIncluded || interval.isMinimumEquals(minimum2.getValue()))
				&& (maximumIncluded || interval.isMaximumEquals(maximum2.getValue()));
	}*/
	
	//protected abstract boolean isMinimumEquals(double value);
	//protected abstract boolean isMaximumEquals(double value);
	
	protected boolean includesBothOpened(Interval interval) {
		boolean minimumIncluded = this.includes(interval.minimum);
		boolean maximumIncluded = this.includes(interval.maximum);
		return (minimumIncluded || minimum.getValue() == interval.minimum.getValue())
				&& (maximumIncluded || maximum.getValue() == interval.maximum.getValue());
	}
	
	public boolean intersectsWith(Interval interval){
		if (minimum.getValue() == interval.maximum.getValue()) {
			return intersectsWithMinimunEqualsMaximumImplementation(interval);
		}
		if (maximum.getValue() == interval.minimum.getValue()) {
			return intersectsWithMaximumEqualsMinimumImplementation(interval);
		
		}
		return this.includes(interval.minimum)
			|| this.includes(interval.maximum);
		}	
	public abstract boolean intersectsWithMinimunEqualsMaximumImplementation(Interval interval);
	public abstract boolean intersectsWithMaximumEqualsMinimumImplementation(Interval interval);

	@Override
	public String toString() {
		// TODO
		return null;
	}

	@Override
	public boolean equals(Object object) {
		// TODO
		return false;
	}

	public Point getMaximum() {
		return maximum;
	}

	public Point getMinimum() {
		return minimum;
	}


	

	


}
