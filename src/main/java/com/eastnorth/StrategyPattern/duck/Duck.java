package com.eastnorth.StrategyPattern.duck;

import com.eastnorth.StrategyPattern.behavier.FlyBehavior;
import com.eastnorth.StrategyPattern.behavier.QuackBehavior;
import lombok.Data;

@Data
public class Duck {
    FlyBehavior flyBehavior;
    QuackBehavior quackBehavior;
    public void swim() {
        System.out.println("我会游泳!");
    }
    public void display() {}
    public void performFly() {
        flyBehavior.fly();
    }
    public void performQuack() {
        quackBehavior.quack();
    }
}
