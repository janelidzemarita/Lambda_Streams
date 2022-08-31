package Figure;

public abstract class Figure implements IFigure, IFigureAnother, Comparable<Figure> {

	public Figure(String helloText) {
		System.out.println(helloText);
	}

	public static final void sayHello() {
		System.out.println("Hello there User");
	}

	abstract double getPerimeter();

	abstract double getArea();

	public void printFigureAreaAndLength() {
		System.out.println("Perimeter: " + getPerimeter() + " Area: " + getArea());
	}

	abstract public void printFigureData();

	abstract public void sayHelloToFigure();

	abstract public boolean validateFigure();

}