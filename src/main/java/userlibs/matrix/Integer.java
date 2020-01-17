package userlibs.matrix;

public class Integer extends Number {

	private int integer;

	public Integer(int integer) {
		super(integer);
	}

	@Override
	public Element plus(Element e) throws IllegalArgumentException {
		//TODO: add functionality for plus
		return null;
	}

	@Override
	public Element times(Element e) {
		//TODO: add functionality for times
		return null;
	}

	@Override
	public Element additiveIdentity() {
		return new Integer(0);
	}

	@Override
	public Element multiplicativeIdentity() {
		return new Integer(1);
	}

	public int getInteger() {
		return integer;
	}

	public void setInteger(int integer) {
		this.integer = integer;
	}

}
