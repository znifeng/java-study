package designpattern.observer;

public class WeatherDataStation {

	public static void main(String[] args) {
		WeatherData weatherData = new WeatherData();
		CurrentConditionsDisplay conditionsDisplay = new CurrentConditionsDisplay(weatherData);
		StatisticsDisplay statisticsDisplay = new StatisticsDisplay(weatherData);
		weatherData.setMeasurements(80, 65, 30.4f);
		weatherData.removeObserver(statisticsDisplay);
		weatherData.setMeasurements(70, 60, 20.5f);
	}	

}
