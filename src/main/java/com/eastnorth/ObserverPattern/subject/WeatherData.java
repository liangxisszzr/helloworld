package com.eastnorth.ObserverPattern.subject;

import com.eastnorth.ObserverPattern.observer.Observer;
import lombok.Data;

import java.util.ArrayList;

/**
 * @desc:天气数据中心
 * @author zuojianhou
 * @date 2019/11/12 21:23
 */
@Data
public class WeatherData implements Subject {

    /**
     * 观察者集合
     */
    private ArrayList observers;

    /**
     * 温度数据
     */
    private float temperature;

    /**
     * 湿度数据
     */
    private float humidity;

    /**
     * 气压数据
     */
    private float pressure;

    /**
     * 构造数据中心初始化观察者
     */
    public WeatherData() {
        observers = new ArrayList();
    }

    /**
     * 观察者注册
     * @param observer
     */
    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    /**
     * 删除观察者
     * @param observer
     */
    public void removeObserver(Observer observer) {
        int i = observers.indexOf(observer);
        if (i >= 0) {
            observers.remove(i);
        }
    }

    /**
     * 通知观察者们
     */
    public void notifyObservers() {
        for (Object o : observers) {
            Observer observer = (Observer) o;
            observer.update(temperature, humidity, pressure);
        }
    }

    /**
     * 测量数据改变
     */
    public void measurementsChanged() {
        notifyObservers();
    }

    /**
     * 设置即时天气数据
     * @param temperature
     * @param humidity
     * @param pressure
     */
    public void setMeasurements(float temperature, float humidity, float pressure) {
        this.temperature = temperature;
        this.humidity = humidity;
        this.pressure = pressure;
        measurementsChanged();
    }
}
