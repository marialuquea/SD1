package Classes;

/**
 * This class sets up a weather reading and contains methods to use on it.
 * @author Maria Luque Anguita 40280156 - Napier number
 */
public class WeatherReading {
	
	//initialising variables - private so that they cannot be changed by the user
	private int siteId;
	private int year;
	private int month;
	private int date;
	private int hour;
	private int windSpeed;
	private double temperature;
	
	/**
	 * Constructor for the WeatherReading object.
	 * 
	 * @param int siteId
	 * @param int year
	 * @param int month
	 * @param int date
	 * @param int hour
	 * @param int windSpeed
	 * @param double temperature
	 */
	public WeatherReading(int siteId, int year, int month, int date, int hour, int windSpeed, double temperature) {
		this.siteId = siteId;
		this.year = year;
		this.month = month;
		this.date = date;
		this.hour = hour;
		this.windSpeed = windSpeed;
		this.temperature = temperature;
	}

	/**
	 * This returns the siteId.
	 * @return int siteId
	 */
	public int getSiteId() {
		return siteId;
	}

	/**
	 * This returns the year
	 * @return int year
	 */
	public int getYear() {
		return year;
	}

	/**
	 * This returns the month
	 * @return int month
	 */
	public int getMonth() {
		return month;
	}

	/**
	 * This returns the date
	 * @return int date
	 */
	public int getDate() {
		return date;
	}

	/**
	 * This returns the hour
	 * @return int hour
	 */
	public int getHour() {
		return hour;
	}

	/**
	 * This returns the wind speed
	 * @return int wind speed
	 */
	public int getWindSpeed() {
		return windSpeed;
	}

	/**
	 * This returns the temperature
	 * @return double temperature
	 */
	public double getTemperature() {
		return temperature;
	}

	/**
	 * This returns the values of the object in a human-readable form.
	 * @return WeatherReading
	 */
	@Override
	public String toString() {
		return "WeatherReading [siteId=" + siteId + ", year=" + year
				+ ", month=" + month + ", date=" + date + ", hour=" + hour
				+ ", windSpeed=" + windSpeed + ", temperature=" + temperature
				+ "]";
	}
	
}
