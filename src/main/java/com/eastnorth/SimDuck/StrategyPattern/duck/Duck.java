package com.eastnorth.SimDuck.StrategyPattern.duck;

import com.eastnorth.SimDuck.StrategyPattern.behavier.FlyBehavior;
import com.eastnorth.SimDuck.StrategyPattern.behavier.QuackBehavior;
import lombok.Data;

@Data
public class Duck {
    FlyBehavior flyBehavior;
    QuackBehavior quackBehavior;
    public void swim() {};
    public void display() {};
    public void performFly() {
        flyBehavior.fly();
    }
    public void performQuack() {
        quackBehavior.quack();
    }
}
