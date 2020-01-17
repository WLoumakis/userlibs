package userlibs.matrix;

public interface Element {

	Element plus(Element e);

	Element times(Element e);

	Element additiveIdentity();

	Element multiplicativeIdentity();

}
