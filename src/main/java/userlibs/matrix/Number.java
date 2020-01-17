package userlibs.matrix;

public abstract class Number implements Element {

	private int integer;
	private double real;

	public Number(int integer) {
		this.integer = integer;
		this.real = 0.0; //TODO: make this some undefined real
	}

	public Number(double real) {
		this.integer = 0; //TODO: make this some undefined int
		this.real = real;
	}

}
