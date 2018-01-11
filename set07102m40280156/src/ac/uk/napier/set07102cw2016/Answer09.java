package ac.uk.napier.set07102cw2016;

import java.util.*;
import Classes.*;
import org.openstreetmap.gui.jmapviewer.Coordinate;
import mapgui.MapGui;

/**
 * QUESTION 09
 * 
 * If you decide to answer question 09 then the main method below should be used as the entry point for your application
 * You may use as many other classes as you feel necessary as long as all code is supplied 
 * 
 * Remember to add -Xmx1024m to the VM arguments using menu run --> run configurations in eclipse
 */

public class Answer09 {
	public static void main(String[] args) {
		System.out.println("Question 09");
		/* 
		 * Add your code below
		 */
		
		//hash map used to store the data from WeatherStation
		HashMap<Integer, WeatherStation> ws = DataManagement.getWeatherStation();
		
		//array list that will store the weather stations with no temperatures below 0ºC
		ArrayList <WeatherStation> over0 = new ArrayList<>();
		//array list that will store the coordinates of the weather stations with no readings below 0ºC
        ArrayList<Coordinate> notbelow0 = new ArrayList<>();
        
        //loop through all weather station values
		for (WeatherStation wS : ws.values()) {
			
			//add all weather stations to the array
			over0.add(wS);
			
			//loop through every temperature reading in the weather stations
			for (int i = 0; i < wS.getWeatherReading().size(); i++) {
				
				//use this variable for easier reading of the code
				double temp = wS.getWeatherReading().get(i).getTemperature();
				
				//if the temperature falls below 0ºC, the weather station will be removed from the array list
				if (temp <= 0){
					over0.remove(wS);	
				}
			}
		}
		
		//for the weather stations left in the array, create a coordinate
		for(int i = 0; i < over0.size();i++){
			
			//create a new weather station to use getLat and Lon and create the coordinate
			WeatherStation toPlot = over0.get(i);
			double lat = toPlot.getLatitude();
			double lon = toPlot.getLongitude();
			
			//create coordinate
			Coordinate coordinate = new Coordinate(lat,lon);
			
			//add to array list
			notbelow0.add(coordinate);	
		}
		
		//plot coordinates inside the array on the map
		MapGui.showMap(notbelow0);
		
		//print data to console
		System.out.println("The number of Weather Stations with temperature readings that isn't 0 or below is "
				+ (over0.size()));		
	}
}