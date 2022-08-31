package Figure;

public class Triangle extends Figure{

	private double ab;
	private double bc;
	private double ca;
	private double height; //height of triangle
	private double s;
	private double angle1;
	private double angle2;
	
	public Triangle() {
		this(3,4,5);
	}

	public Triangle(double ab, double bc, double ca) {
		super("Hello there! Triangle is created!");
		this.ab = ab;
		this.bc = bc;
		this.ca = ca;
		this.s = (ab + bc + ca)/2;
		this.height = 2 * Math.sqrt(s * (s - ab) * (s - bc) * (s - ca)) / ca ;  //formula to calculate height
		this.angle1 = Math.acos((bc * bc + ca * ca - ab * ab)/(2 * bc * ca));
		this.angle2 = Math.acos((bc * bc + ab * ab - ca * ca)/(2 * bc * ab));
	}

	public double getAB() {
		return ab;
	}

	public void setAB(double ab) {
		this.ab = ab;
	}

	public double getBC() {
		return bc;
	}

	public void setBC(double bc) {
		this.bc = bc;
	}

	public double getCA() {
		return ca;
	}

	public void setCA(double ca) {
		this.ca = ca;
	}
	@Override
	public double getPerimeter() {
		return ab + bc + ca;
	}
	@Override
	public double getArea() {
		return (this.height * ca) / 2;
	}
	

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Triangle {ab=");
		builder.append(ab);
		builder.append(", bc=");
		builder.append(bc);
		builder.append(", ca=");
		builder.append(ca);
		builder.append("}");
		return builder.toString();
	}

	public boolean equals(Triangle obj1, Triangle obj2) {
		if (!(obj1 instanceof Figure) || !(obj2 instanceof Figure) || obj1 == null || obj2 == null)
			return false;
		return obj1.getPerimeter() == obj2.getPerimeter();
	}
	
	public int getTriangleType() {
		if(this.ab >= this.bc && this.ab >= this.ca) {
			if(Math.sqrt(this.bc * this.bc + this.ca * this.ca) == ab){
				return 0;
			}else if(Math.sqrt(this.bc * this.bc + this.ca * this.ca) < ab) {
				return -1;
			}else return 1;
		}else if(this.bc >= this.ab && this.bc >= this.ca) {
			if(Math.sqrt(this.ab * this.ab + this.ca * this.ca) == this.bc){
				return 0;
			}else if(Math.sqrt(this.ab * this.ab + this.ca * this.ca) < this.bc) {
				return -1;
			}else return 1;
		}else {
			if(Math.sqrt(this.ab * this.ab + this.bc * this.bc) == this.ca){
				return 0;
			}else if(Math.sqrt(this.ab * this.ab + this.bc * this.bc) < this.ca) {
				return -1;
			}else return 1;
		}
	}

	@Override
	public void printFigureData() {
		System.out.println("Side 1: " + ab + " Side 2: " + bc + " Side 3: " + ca);
	}

	@Override
	public void sayHelloToFigure() {
		System.out.println("Hello from Triangle");
		
	}

	@Override
	public boolean validateFigure() {
		if(ab + bc > ca && ab + ca > bc && bc + ca > ab && ab > 0 && bc > 0 && ca >0) {
			return true;
		}
		return false;
	}
	/*
	 Task 1. 06.07.2022
	 
	 Triangle does not have a getLength method but has a getPerimeter so I used that.
	 */

	@Override
	public int compareTo(Figure o) {

		return Double.compare(o.getPerimeter(), this.getPerimeter());
	}
	public boolean isRightTriangle() {
		if((ab * ab) == bc * bc + ca * ca || (bc * bc) == ab * ab + ca * ca  
				|| (ca * ca) == ab * ab + bc * bc) {
			return true;
		}
		return false;
	}
}