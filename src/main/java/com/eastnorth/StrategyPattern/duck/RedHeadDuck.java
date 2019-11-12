package com.eastnorth.StrategyPattern.duck;

import lombok.Data;

@Data
public class RedHeadDuck extends Duck {
    @Override
    public void display() {
        System.out.println("红头鸭子");
    }
}
