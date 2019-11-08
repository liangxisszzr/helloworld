package com.eastnorth.SimDuck.duck;

import lombok.Data;

@Data
public class RubberDuck extends Duck {
    @Override
    public void display() {
        System.out.println("橡皮鸭子");
    }
    @Override
    public void quack() {
        System.out.println("吱吱叫");
    }
}
