package com.eastnorth.ObserverPattern.subject;

import lombok.Data;

import java.util.Observable;

@Data
public class NewWeatherData extends Observable {
    private float temperature;
    private float humidity;
    private float pressure;

    public NewWeatherData() {}

    public void measurementsChanged() {
        setChanged();
        notifyObservers();
    }

    public void setMeasurements(float temperature, float humidity, float pressure) {
        this.temperature = temperature;
        this.humidity = humidity;
        this.pressure = pressure;
        measurementsChanged();
    }

}
