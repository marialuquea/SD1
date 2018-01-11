package ac.uk.napier.set07102cw2016;

import java.util.*;

import Classes.*;

import org.openstreetmap.gui.jmapviewer.Coordinate;

import mapgui.MapGui;

/**
 * QUESTION 08
 * 
 * If you decide to answer question 08 then the main method below should be used as the entry point for your application
 * You may use as many other classes as you feel necessary as long as all code is supplied 
 * 
 * Remember to add -Xmx1024m to the VM arguments using menu run --> run configurations in eclipse
 */
public class Answer08 {
	public static void main(String[] args) {
		System.out.println("Question 08");
		/*
		 * Add your code below
		 */
		//creating variables for later use using min and max values to make sure there is no problem
		double comparemin = Double.MAX_VALUE;
		double comparemax = Double.MIN_VALUE; 
		double sum = 0;
		int count = 0;
		
		//hashmap used to store the data from WeatherStation
		HashMap<Integer, WeatherStation> ws = DataManagement.getWeatherStation();
		
		//loop through all the readings for weather station 3840
		for (int i = 0; i < ws.get(3840).getWeatherReading().size(); i++) {

			//use a word (hour, month, siteid) to make it easier to read the code afterwards
			int hour = ws.get(3840).getWeatherReading().get(i).getHour();
			int month = ws.get(3840).getWeatherReading().get(i).getMonth();
			double temp = ws.get(3840).getWeatherReading().get(i).getTemperature();
			
			//look at 11 AM the 15th of July
			if ((hour == 11) && (month == 7)) {
				//setting variables to calculate the median
				sum += temp;
				count++;
				//setting maximum and minimum values
				if (temp > comparemax) {
					comparemax = temp;
				}
				if (temp < comparemin) {
					comparemin = temp;
				}
			}
		}

		//print values to the console
		System.out.println("The minimum is " + comparemin);
		System.out.println("The maximum is " + comparemax);
		System.out.println("The average is " + (sum / count));
		
		//create coordinate to plot on the map
		double lat = ws.get(3840).getLatitude();
		double lon = ws.get(3840).getLongitude();
		Coordinate coord = new Coordinate(lat, lon);
		MapGui.showMap(coord);	
	}	
}
