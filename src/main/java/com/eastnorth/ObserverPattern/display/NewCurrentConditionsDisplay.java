package com.eastnorth.ObserverPattern.display;

import com.eastnorth.ObserverPattern.subject.NewWeatherData;
import lombok.Data;

import java.util.Observable;
import java.util.Observer;

@Data
public class NewCurrentConditionsDisplay implements Observer, DisplayElement {
    Observable observable;
    private float temperature;
    private float humidity;

    public NewCurrentConditionsDisplay(Observable observable) {
        this.observable = observable;
        observable.addObserver(this);
    }

    public void display() {
        System.out.println("Current conditions: " + temperature + "F degrees and " + humidity + "% humidity");
    }

    public void update(Observable o, Object arg) {
        if (o instanceof NewWeatherData) {
            NewWeatherData newWeatherData = (NewWeatherData) o;
            this.temperature = newWeatherData.getTemperature();
            this.humidity = newWeatherData.getHumidity();
            display();
        }
    }
}
