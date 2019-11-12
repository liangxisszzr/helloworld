package com.eastnorth.StrategyPattern.behavier;

/**
 * 无法发声
 */
public class MuteQuack implements QuackBehavior {
    public void quack() {
        System.out.println("呜呜呜，我不会叫!");
    }
}
