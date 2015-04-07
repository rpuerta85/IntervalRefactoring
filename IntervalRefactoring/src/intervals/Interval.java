package intervals;

import utils.Point;

public abstract class Interval {

	protected Point maximum2;
	protected Point minimum2;
	
	protected Opening opening;

	 Interval(Point minimum, Point maximum, Opening opening) {
		this.minimum2 = minimum;
		this.maximum2 = maximum;
		this.opening = opening;
		
	}
	 
	public double midPoint() {
		return (maximum2.getValue() + minimum2.getValue()) / 2;
	}

	public boolean includes(double value) {
		return minimum2.isLessThan(value) && maximum2.isGreaterThan(value);
	}
	public abstract boolean includes(Interval interval);

	public abstract boolean amIIncludeInInterval(BothOpened bothOpened);
	public abstract boolean amIIncludeInInterval(LeftOpened leftOpened) ;
	public abstract boolean amIIncludeInInterval(RightOpened rightOpened);
	public abstract boolean amIIncludeInInterval(UnOpened unOpened);
	
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
		boolean minimumIncluded = this.includes(interval.minimum2.getValue());
		boolean maximumIncluded = this.includes(interval.maximum2.getValue());
		return (minimumIncluded || minimum2.getValue() == interval.minimum2.getValue())
				&& (maximumIncluded || maximum2.getValue() == interval.maximum2.getValue());
	}
	
	public boolean intersectsWith(Interval interval){
		if (minimum2.getValue() == interval.maximum2.getValue()) {
			return intersectsWithMinimunEqualsMaximumImplementation(interval);
		}
		if (maximum2.getValue() == interval.minimum2.getValue()) {
			return intersectsWithMaximumEqualsMinimumImplementation(interval);
		
		}
		return this.includes(interval.minimum2.getValue())
			|| this.includes(interval.maximum2.getValue());
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


	

	


}
