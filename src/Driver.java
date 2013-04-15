import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;


public class Driver {
	public static void main(String[] args) {
		BufferedReader br = null;
		//String pathToFile = "venusdb_tabdelimited.txt";
		String pathToFile = "lunarcraters.txt";
		Vertex newVertex;
		
		try {
			br = new BufferedReader(new FileReader(new File(pathToFile)));
		} catch (FileNotFoundException e) {
			//error finding file
		}
		
		//surround in try/catch to handle IOException on reading input
		//throw the exception since closing the bufferedreader could throw an IOException as well
		try {
			//reuse to store current line split into string array
	        String[] line = null;
	        int id;
	        String name;
	        double latitude, longitude, depth, diameter;
	       
	        ArrayList<Vertex> vertices = new ArrayList<Vertex>();
	         
	        //keep reading while there's more to read 
			while (br.ready()) {        	 
				//split the current line into an array of strings 
				line = br.readLine().split("\t");
				
				name = line[0];
				latitude = getValue(line[2]); //latitude of crater
				longitude = getValue(line[3]); //longitude of crater
				diameter = getValue(line[1]); //diameter of crater
				depth = Double.valueOf(line[12]); //depth of crater
				
				newVertex = new Vertex(name, latitude, longitude, diameter, depth);
				vertices.add(newVertex);
				System.out.println("Added: " + newVertex);
			 }
			
			Collections.sort(vertices);
			
			for (Vertex v : vertices) {
				System.out.println(v.getName() + " " + v + " " + "Distance From Apollo Landing Site: " + v.getDistanceFromApollo());
			}
		} catch (IOException e) {
			System.out.println(e.getMessage());
		} finally {
			//make sure to close the reader
			try {
				br.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	//safely parse an input string to a double value. 
	private static double getValue(String numberString) {
		//default value to return if input cannot be parsed into a double (e.g. if it is the empty string)
		double convertedValue = 0.0;
		
		try {
			convertedValue = Double.valueOf(numberString);
		} catch (NumberFormatException ex) {
			//eat the exception. we'll just return 0.0 for missing/malformed values.
		}
		return convertedValue;
	}
}
