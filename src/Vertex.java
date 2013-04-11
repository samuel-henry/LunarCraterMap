import java.awt.Point;

public class Vertex implements Comparable<Vertex> {
	private static final Point ARIADNE_CRATER = new Point(44, 0);
	private int id;
	private String name;
	private double latitudeValue, longitudeValue, radiusValue, distanceFromAriadne;
	private Point vertexPoint;
	
	//constructor for non-crater vertices? maybe just pass in constant radius for non-crater points
	public Vertex(double xValue, double yValue) {
		//create a point (useful for sorting)
		this.vertexPoint = new Point((int) xValue, (int) yValue);
		this.latitudeValue = xValue;
		this.longitudeValue = yValue;
	}
	
	public Vertex (int id, String name, double latitudeValue, double longitudeValue, double radiusValue) {
		this.id = id;
		this.name = name;
		this.latitudeValue = latitudeValue;
		this.longitudeValue = longitudeValue;
		this.vertexPoint = new Point((int) latitudeValue, (int) longitudeValue);
		this.radiusValue = radiusValue;
		this.distanceFromAriadne = this.vertexPoint.distance(ARIADNE_CRATER);
	}
	
	public Point getPoint() {
		return this.vertexPoint;
	}
	
	public String getName() {
		return this.name;
	}
	
	public double getLatitudeValue() {
		return this.latitudeValue;
	}
	
	public double getLongitudeValue() {
		return this.longitudeValue;
	}
	
	public double getRadiusValue() {
		return this.radiusValue;
	}
	
	public double getDistanceFromAriadne() {
		return this.distanceFromAriadne;
	}
	
	@Override
	public String toString() {
		return "X: " + this.getLatitudeValue() + " Y: " + this.getLongitudeValue() + " Z: " + this.getRadiusValue();
	}
	
	@Override
	public int compareTo(Vertex compareVertex) {	
		if (this.distanceFromAriadne > compareVertex.getDistanceFromAriadne()) {
			return 1;
		} else if (this.distanceFromAriadne < compareVertex.getDistanceFromAriadne()) {
			return -1;
		} else {
			return 0;
		}
		
		
	}

}
