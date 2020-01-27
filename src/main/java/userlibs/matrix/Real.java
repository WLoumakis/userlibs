package userlibs.matrix;

import lombok.Getter;
import lombok.Setter;
import userlibs.exceptions.matrix.ElementTypeException;

public class Real implements Element {

	public static final Element ADDITIVE_IDENTITY = new Real(0.0);
	public static final Element MULTIPLICATIVE_IDENTITY = new Real(1.0);

	@Getter
	@Setter
	private double number;

	public Real (int number) {
		this.number = (double) number;
	}

	public Real(double number) {
		this.number = number;
	}

	public static Element plus(Element a, Element b) throws ElementTypeException {
		if (a instanceof Real && b instanceof Real)
			return new Real(((Real) a).number + ((Real) b).number);
		throw new ElementTypeException("Cannot add two elements of differing runtime types!");
	}

	public static Element times(Element a, Element b) throws ElementTypeException {
		if (a instanceof Real && b instanceof Real)
			return new Real(((Real) a).number * ((Real) b).number);
		throw new ElementTypeException("Cannot multiply two elements of differing runtime types!");
	}

	@Override
	public boolean equals(Element e) {
		if (e instanceof Real) {
			double diff = Math.abs(number - ((Real)e).getNumber());
			double SAME_NUMBER = 1e-05;
			return diff <= SAME_NUMBER;
		}
		return false;
	}

}
