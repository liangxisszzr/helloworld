package com.eastnorth.ObserverPattern.subject;

import com.eastnorth.ObserverPattern.observer.Observer;

/**
 * @desc:主题
 * @author zuojianhou
 * @date 2019/11/12 19:56
 */
public interface Subject {

    /**
     * @desc:观察者注册
     * @param observer
     */
    void registerObserver(Observer observer);

    /**
     * @desc:删除观察者
     * @param observer
     */
    void removeObserver(Observer observer);

    /**
     * @desc:通知观察者
     */
    void notifyObservers();
}
