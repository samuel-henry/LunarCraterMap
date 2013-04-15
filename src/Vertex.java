import java.awt.Point;

public class Vertex implements Comparable<Vertex> {
	private static final Point APOLLO_LANDING_SITE = new Point(0, 23);
	private String name;
	private double latitude, longitude, depth, diameter, distanceFromApollo;
	private Point vertexPoint;
	
	//constructor for non-crater vertices? maybe just pass in constant radius for non-crater points
	public Vertex(double xValue, double yValue) {
		//create a point (useful for sorting)
		this.vertexPoint = new Point((int) xValue, (int) yValue);
		this.latitude = xValue;
		this.longitude = yValue;
	}
	
	//constructor for crater vertices
	public Vertex(String name, double latitudeValue, double longitudeValue, double diameterValue, double depthValue) {
		this.name = name;
		this.latitude = latitudeValue;
		this.longitude = longitudeValue;
		this.vertexPoint = new Point((int) latitudeValue, (int) longitudeValue);
		this.depth = depthValue;
		this.diameter = diameterValue;
		this.distanceFromApollo = this.vertexPoint.distance(APOLLO_LANDING_SITE);
	}

	public Point getPoint() {
		return this.vertexPoint;
	}
	
	public String getName() {
		return this.name;
	}
	
	public double getLatitudeValue() {
		return this.latitude;
	}
	
	public double getLongitudeValue() {
		return this.longitude;
	}
	
	public double getRadiusValue() {
		return this.diameter / 2;
	}
	
	public double getDiameterValue() {
		return this.diameter;
	}
	
	public double getDistanceFromApollo() {
		return this.distanceFromApollo;
	}
	
	@Override
	public String toString() {
		return "Latitude: " + this.getLatitudeValue() + " Longitude: " + this.getLongitudeValue() + " Depth: " + this.getRadiusValue();
	}
	
	@Override
	public int compareTo(Vertex compareVertex) {	
		if (this.distanceFromApollo > compareVertex.getDistanceFromApollo()) {
			return 1;
		} else if (this.distanceFromApollo < compareVertex.getDistanceFromApollo()) {
			return -1;
		} else {
			return 0;
		}
		
		
	}

}
