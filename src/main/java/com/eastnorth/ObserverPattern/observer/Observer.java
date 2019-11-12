package com.eastnorth.ObserverPattern.observer;

/**
 * @desc:观察者接口
 * @author zuojianhou
 * @date: 2019/11/12 20:02
 */
public interface Observer {

    /**
     *
     * @param temperature
     * @param humidity
     * @param pressure
     */
    void update(float temperature, float humidity, float pressure);
}
