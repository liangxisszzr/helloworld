package com.eastnorth.StrategyPattern.behavier;

/**
 * 可以飞行
 */
public class FlyWithWing implements FlyBehavior {
    public void fly() {
        System.out.println("我有翅膀我会飞!");
    }
}
