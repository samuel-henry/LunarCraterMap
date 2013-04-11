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
		String pathToFile = "venusdb_tabdelimited.txt";
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
	        double xValue, yValue, zValue;
	        
	        //initialize customers map to hashmap of String (name) --> Acount
	        ArrayList<Vertex> vertices = new ArrayList<Vertex>();
	         
	        //keep reading while there's more to read 
			while (br.ready()) {        	 
				//split the current line into an array of strings 
				line = br.readLine().split("\t");
				
				id = Integer.valueOf(line[0]);
				name = line[1];
				xValue = Double.valueOf(line[2]);
				yValue = Double.valueOf(line[3]);
				zValue = Double.valueOf(line[4]);
				
				newVertex = new Vertex(id, name, xValue, yValue, zValue);
				vertices.add(newVertex);
				System.out.println("Added: " + newVertex);
			 }
			
			Collections.sort(vertices);
			
			for (Vertex v : vertices) {
				System.out.println(v.getName() + " " + v + " " + "Distance From Ariadne: " + v.getDistanceFromAriadne());
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
}
