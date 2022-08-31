package Figure;

//Rectangle is the child of Figure

//I left the old methods(form previous assignments) as they were. ( the ones where we didn't have to change anything)
public class Rectangle extends Figure{
	private static final double MAX_LENGTH ;
	private static final double MAX_HEIGHT ;

	static {
		MAX_LENGTH = 200;
		MAX_HEIGHT = 200;
	}
	
	private double length;
	private double height;
	
	public Rectangle(double length, double height) {
		super("Hello User From Figure Constructor!");
		setHeight(height);
		setLength(length);
	}
	
	public Rectangle() {
		this(3,4);
	}
	
	public double getLength() {
		return length;
	}
	
	public void setLength(double length) {
		if(length < MAX_LENGTH) {
			this.length = length;
		}else this.length = MAX_LENGTH;
	}
	
	public double getHigth() {
		return height;
	}
	
	public void setHeight(double height) {
		if(height < MAX_HEIGHT) {
			this.height = height;
		}else this.height = MAX_HEIGHT;
		
	}
	
	@Override
	protected double getPerimeter () {
		return  this.length *2 + this.height * 2;
	}
	@Override
	protected double getArea() {
		return this.length * this.height;
	}
	
	protected static double getPerimeter (double length, double height) {
		return  length *2 + height * 2;
	}
	
	protected static double getArea(double length, double height) {
		return length * height;
	}
	

	public int Compare(Rectangle rec) {
		if(rec.getArea() > this.getArea()) {
			return 1;
		}else if (rec.getArea() < this.getArea()) {
			return -1;
		}else
		return 0;
	}
	public static Rectangle getMaxAreaRectangle(Rectangle[] array ) { //Here we had to return the Object with max area
		double max = array[0].getArea();
		Rectangle result = array[0];
		for(int i = 0; i < array.length; i++) {
			if(array[i].getArea() > max) {
				max = array[i].getArea();
				result = array[i];
			}
		}
		return result; 
	}

	@Override
	public String toString() {
		return "Rectangle {length=" + length + ", height=" + height + "}";
	}

	public boolean equals(Rectangle obj1, Rectangle obj2) { //We pass two Rectangle type objects
		if (obj1 == null || obj2 == null)
			return false;
		
		//return true if their areas are equal, false otherwise;
				
		return obj1.getArea() == obj2.getArea();

	}
	public double calculateDiagonal() {
		return Math.sqrt(this.height * this.height + this.length * this.length);
	}

	@Override
	public void printFigureData() {
		System.out.println("Rectangle height: " + height + " Length: " + length);
	}

	@Override
	public void sayHelloToFigure() {
		System.out.println("Hello from Rectangle");
		
	}

	@Override
	public boolean validateFigure() {
		if(length > 0.0 && height > 0.0) {
			return true;
		}
		return false;
	}
	/*
	 Task 1. 06.07.2022
	 I used getPerimeter insted of getLength, all our figures has getPerimeter but not getLength
	 */

	@Override
	public int compareTo(Figure o) {

		return -Double.compare(o.getPerimeter(), this.getPerimeter());
	}
	
}