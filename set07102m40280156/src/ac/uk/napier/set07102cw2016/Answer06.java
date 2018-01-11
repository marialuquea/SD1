package ac.uk.napier.set07102cw2016;

import java.util.*;
import Classes.*;
import org.openstreetmap.gui.jmapviewer.Coordinate;
import mapgui.MapGui;

/**
 * QUESTION 06
 * 
 * If you decide to answer question 06 then the main method below should be used as the entry point for your application
 * You may use as many other classes as you feel necessary as long as all code is supplied 
 * 
 * Remember to add -Xmx1024m to the VM arguments using menu run --> run configurations in eclipse
 */
public class Answer06 {
	public static void main(String[] args) {
		System.out.println("Question 06");
		/*
		 * Add your code below
		 */
		
		//get data from WeatherStation and put it in a HashMap
		HashMap<Integer, WeatherStation> ws = DataManagement.getWeatherStation();
		
		//create a weatherstation to store the values of the weather station with less weather readings
		WeatherStation fewestws = null;
		
		//declare a variable to compare in later use
		int fewest = Integer.MAX_VALUE;
		
		//loop through all weather station values
		for (WeatherStation wS : ws.values()) {
			
			//put the values in an arraylist
			ArrayList<WeatherReading> readinglist = wS.getWeatherReading();
			
			//the arraylist with less values is the weather station with less readings	 
			int current = readinglist.size();

			//compare with int fewest and set the weather station if it is smaller in size
			if (current < fewest) {
				fewest = current;
				fewestws = wS;
			}
		}
		
		//make the coordinate and plot it on the map
		double lat = fewestws.getLatitude();
		double lon = fewestws.getLongitude();
		Coordinate coord = new Coordinate(lat, lon);
		MapGui.showMap(coord);
		
		//print answer to console
		System.out.println("The weather station with fewer weather readings is:");
		System.out.println(fewestws.getSiteName());
		System.out.println("In latitude: "+fewestws.getLatitude() +" and longitude: "+ fewestws.getLongitude());
	}	
}