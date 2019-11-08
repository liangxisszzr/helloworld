package com.eastnorth.SimDuck.duck;

import lombok.Data;

@Data
public class MallardDuck extends Duck {
    @Override
    public void display() {
        System.out.println("绿头鸭子");
    }
}
