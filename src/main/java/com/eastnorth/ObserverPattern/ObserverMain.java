package com.eastnorth.ObserverPattern;

import com.eastnorth.ObserverPattern.display.CurrentConditionsDisplay;
import com.eastnorth.ObserverPattern.subject.WeatherData;

public class ObserverMain {
    public static void main(String[] args) {
        WeatherData weatherData = new WeatherData();

        CurrentConditionsDisplay currentConditionsDisplay = new CurrentConditionsDisplay(weatherData);

//        StatisticsDisplay statisticsDisplay = new StatisticsDisplay(weatherData);
//        ForecastDisplay forecastDisplay = new ForecastDisplay(weatherData);

        weatherData.setMeasurements(80, 65, 30.4f);
        weatherData.setMeasurements(82, 70, 29.2f);
        weatherData.setMeasurements(78, 90, 29.2f);

        currentConditionsDisplay.display();

        currentConditionsDisplay.setHumidity(weatherData.getHumidity());

        System.out.println(currentConditionsDisplay.getHumidity());
    }
}
