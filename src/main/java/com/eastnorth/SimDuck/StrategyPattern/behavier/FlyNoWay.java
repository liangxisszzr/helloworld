package com.eastnorth.SimDuck.StrategyPattern.behavier;

public class FlyNoWay implements FlyBehavior {
    public void fly() {
        System.out.println("呜呜呜，我不会飞!");
    }
}
