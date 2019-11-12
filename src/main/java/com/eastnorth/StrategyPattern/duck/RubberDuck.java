package com.eastnorth.StrategyPattern.duck;

import lombok.Data;

@Data
public class RubberDuck extends Duck {
    @Override
    public void display() {
        System.out.println("橡皮鸭子");
    }
}
