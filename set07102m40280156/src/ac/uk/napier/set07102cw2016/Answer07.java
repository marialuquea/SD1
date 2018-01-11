package ac.uk.napier.set07102cw2016;

import java.util.*;

import Classes.*;

import org.openstreetmap.gui.jmapviewer.Coordinate;

import mapgui.MapGui;

/**
 * QUESTION 07
 * 
 * If you decide to answer question 07 then the main method below should be used as the entry point for your application
 * You may use as many other classes as you feel necessary as long as all code is supplied 
 * 
 * Remember to add -Xmx1024m to the VM arguments using menu run --> run configurations in eclipse
 */
public class Answer07 {
	public static void main(String[] args) {
		System.out.println("Question 07");
		/*
		 * Add your code below
		 */
		//hashmap used to store the data from WeatherStation
		HashMap<Integer, WeatherStation> ws = DataManagement.getWeatherStation();
		
		//declare variable for later use to compare, it is set to minimum value so that the first value is certainly bigger
		double highesttemp = Integer.MIN_VALUE;
		
		//create a new empty weather station object for later use
		WeatherStation ws1 = null;
		
		//variables used to store the values I want to print later 
		int year = 0;
		int month = 0;
		int date = 0;
		int hour = 0;
		
		//loop through all weather station values
		for (WeatherStation wS : ws.values()) {
		
			//loop to go through every weather station (i is the weather station id)
			for(int i = 0; i < wS.getWeatherReading().size(); i++){
				
				//new variable used to get every temperature reading of every weather station
				double temp = wS.getWeatherReading().get(i).getTemperature();
						
				//compare highest temperature set before, to the rest and change if condition is met
				if (temp > highesttemp){
					highesttemp = temp;
					//fill the empty weather station with this weather stations values
					ws1 = wS;
					//set values of this weather station to print later
					year = wS.getWeatherReading().get(i).getYear();
					month = wS.getWeatherReading().get(i).getMonth();
					date = wS.getWeatherReading().get(i).getDate();
					hour = wS.getWeatherReading().get(i).getHour();
				}
			}
		}
		
		//create coordinate to plot on the map
        double lat = ws1.getLatitude();
        double lon = ws1.getLongitude();
        Coordinate coord = new Coordinate(lat, lon);
        MapGui.showMap(coord);
        
        //print data to the console
        System.out.println("The highest temperature recorded was in:");
		System.out.println(ws1.getSiteId() + ", " + ws1.getSiteName());
		System.out.println("with a temperature of "+highesttemp+"ºC at "+date+"/"+month +"/"+year+" "+hour+":00.");
	}
}