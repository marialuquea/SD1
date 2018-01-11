package Classes;

import java.util.ArrayList;

/**
 * This is the class that sets up a weather station object and contains the methods for it.
 * @author Maria Luque Anguita 40280156 - Napier number
 */
public class WeatherStation {
	
	//initialising variables - private so that they cannot be changed by the user
	private int siteId;
	private String siteName;
	private double latitude;
	private double longitude;
	private ArrayList<WeatherReading> weatherReading1 = new ArrayList<>();
	
	/**
	 * The constructor for the WeatherStation object.
	 * @param int siteId
	 * @param String siteName
	 * @param double latitude
	 * @param double longitude
	 */
	public WeatherStation(int siteId, String siteName, double latitude, double longitude) {
		this.siteId = siteId;
		this.siteName = siteName;
		this.latitude = latitude;
		this.longitude = longitude;
	}

	/**
	 * This returns the siteId.
	 * @return int siteId
	 */
	public int getSiteId() {
		return siteId;
	}

	/**
	 * This returns the site name
	 * @return String siteName
	 */
	public String getSiteName() {
		return siteName;
	}

	/**
	 * This returns the latitude
	 * @return double latitude
	 */
	public double getLatitude() {
		return latitude;
	}

	/**
	 * This returns the longitude
	 * @return double longitude
	 */
	public double getLongitude() {
		return longitude;
	}

	/**
	 * This returns an array of weather readings
	 * @return ArrayList weatherReading1
	 */
	public ArrayList<WeatherReading> getWeatherReading() {
		return weatherReading1;
	}
	
	/**
	 * This takes a reading and adds it to the weatherReading1 ArrayList
	 * @param reading
	 */
	public void addReading(WeatherReading reading) {
		weatherReading1.add(reading);
	}

	/**
	 * This returns the values of the object in a human-readable form.
	 * @return WeatherStation
	 */
	@Override
	public String toString() {
		return "WeatherStation [siteId=" + siteId + ", siteName=" + siteName
				+ ", latitude=" + latitude + ", longitude=" + longitude
				+ ", weatherReading1=" + weatherReading1 + "]";
	}
}
