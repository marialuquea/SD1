package ac.uk.napier.set07102cw2016;

import java.util.*;
import Classes.*;
import org.openstreetmap.gui.jmapviewer.Coordinate;
import mapgui.MapGui;

/**
 * QUESTION 10
 * 
 * If you decide to answer question 10 then the main method below should be used as the entry point for your application
 * You may use as many other classes as you feel necessary as long as all code is supplied 
 * 
 * Remember to add -Xmx1024m to the VM arguments using menu run --> run configurations in eclipse
 */
public class Answer10 {
	public static void main(String[] args) {
		System.out.println("Question 10");
		/*
		 * Add your code below
		 */
		
		//hash map used to store the data from WeatherStation
		HashMap<Integer, WeatherStation> ws = DataManagement.getWeatherStation(); 
		
		//variables initialized
		double latitude = Double.MAX_VALUE;
		double longitude = 0;
		String sitename = null;
		WeatherStation south = null;
		
		//loop through every value in WeatherStation
		for (WeatherStation wS : ws.values()) {
			
			//loop through all readings 
			for (int i = 0; i < wS.getWeatherReading().size(); i++) {
                
				//compare and set smallest latitude (= most southerly weather station)
				if (wS.getLatitude() < latitude) {
					latitude = wS.getLatitude();
					longitude = wS.getLongitude();
					sitename = wS.getSiteName();
					
					//add the weather station to "south" with all its values
					south = wS;
				}
			}
		}
		
		//create coordinate to plot on map
		double lat = south.getLatitude();
		double lon = south.getLongitude();
		Coordinate coord = new Coordinate(lat, lon);
		MapGui.showMap(coord);
		
		//print data to the console
		System.out.println("The most southerly weather station is:");
		System.out.println(sitename + ". In latitude "+latitude+" and longitude "+longitude+".");
		
	}
}	

