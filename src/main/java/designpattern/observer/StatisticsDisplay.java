package designpattern.observer;

public class StatisticsDisplay implements Observer, Display {
	private float temperature;
	private Subject weatherData;
	
	public StatisticsDisplay(Subject weatherData) {
		this.weatherData = weatherData;
		this.weatherData.registerObserver(this);
	}
	@Override
	public void display() {
		System.out.println("The maximum temperature is: " + temperature);
		
	}

	@Override
	public void update(WeatherData weatherData) {
		this.temperature = weatherData.getTemperature();
		this.display();
	}
	

}
