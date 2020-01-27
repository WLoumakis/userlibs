package userlibs.matrix;

import userlibs.exceptions.matrix.ElementTypeException;

public interface Element {

	static Element plus(Element a, Element b) throws ElementTypeException {
		return null;
	}

	static Element times(Element a, Element b) throws ElementTypeException {
		return null;
	}

	boolean equals(Element e);

}
