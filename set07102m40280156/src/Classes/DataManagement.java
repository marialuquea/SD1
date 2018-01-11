package Classes;

import java.util.HashMap;
import weather.WeatherData;

/**
 * This class returns the weather data as a HashMap to use.
 * @author Maria Luque Anguita 40280156 - Napier number
 */
public class DataManagement {
	
	/**
	 * This class is used to read the data from the excel files and manage it in a way
	 * that it is easier to use it e.g. each value in its correct type.
	 * The first loop has only the weather station properties, but not the weather readings, and adds 
	 * them to a HashMap.
	 * The second "for" loop does the same procedure but for the weather readings, which are added
	 * into the weatherstation hash map as well.
	 * 
	 * Finally the weatherstation hash map is returned.
	 * @return weatherstations
	 */
	public static HashMap<Integer, WeatherStation> getWeatherStation() {
		//create a HashMap to store the data from the excel files
		HashMap<Integer, WeatherStation> weatherstations = new HashMap<>();
		
		//this array is used to store the data from the WeatherData
		String[] data = WeatherData.getData();
		
		//loop through every value in data
		for (int i = 1; i<data.length; i++){
			
			//get the next line
			String line = data[i];
			
			//split the string 
			String[] elements = line.split(",");
			
			//get string elements separately
			String siteidstring = elements[0];
			String sitename = elements[1];
			String latstring = elements[2];
			String lonstring = elements [3];
					
			//conversions to correct types using the parse method
			int siteid = Integer.parseInt(siteidstring);
			double lat = Double.parseDouble(latstring);
			double lon = Double.parseDouble(lonstring);
			
			//create a new weather station object with variables
			WeatherStation weatherstation2 = new WeatherStation(siteid, sitename, lat, lon);
			//the HashMap is in the form <Integer, WeatherStation> so this is how I add it
			weatherstations.put(siteid, weatherstation2);				
		}
		
		//loop through every value in data
		for (int i = 1; i<data.length; i++){
			
			//get the next line
			String line = data[i];
			
			//split the string 
			String[] elements = line.split(",");
			
			//get string elements separately
			String siteidstring = elements[0];
			String yearstring = elements[4];
			String monthstring = elements[5];
			String datestring = elements[6];
			String hourstring = elements[7];
			String windSpeedstring = elements[8];
			String temperaturestring = elements[9];
			
			//conversions to correct types using the parse method
			int siteid = Integer.parseInt(siteidstring);
			int year = Integer.parseInt(yearstring);
			int month = Integer.parseInt(monthstring);
			int date = Integer.parseInt(datestring);
			int hour = Integer.parseInt(hourstring);
			int windSpeed = Integer.parseInt(windSpeedstring);
			double temp = Double.parseDouble(temperaturestring);
			
			//create a new weather station for each site
			WeatherStation weather = weatherstations.get(siteid); 
			//each weather station has more than one reading
			WeatherReading reading = new WeatherReading(siteid, year, month, date, hour, windSpeed, temp);
			//adding each reading using the method "addReading()" from the WeatherStation class
			weather.addReading(reading);
			
		}
		return weatherstations;
	}
}