package com.eastnorth.StrategyPattern.behavier;

/**
 * 无法飞行
 */
public class FlyNoWay implements FlyBehavior {
    public void fly() {
        System.out.println("呜呜呜，我不会飞!");
    }
}
