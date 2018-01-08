package designpattern.observer;

public class CurrentConditionsDisplay implements Observer, Display{
	private float temperature;
	private float humidity;
	private float pressure;
	private Subject WeatherData;
	
	public CurrentConditionsDisplay(Subject WeatherData) {
		this.WeatherData = WeatherData;
		this.WeatherData.registerObserver(this);
	}
	
	@Override
	public void display() {
		System.out.println("Temperature: " + temperature + ", Humidity: " + humidity + ", Pressure: " + pressure);
	}
	
	@Override
	public void update(WeatherData weatherData) {
		this.temperature = weatherData.getTemperature();
		this.humidity = weatherData.getHumidity();
		this.pressure = weatherData.getPressure();
		this.display();
	}



}
