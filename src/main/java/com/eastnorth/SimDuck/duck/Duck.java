package com.eastnorth.SimDuck.duck;

import lombok.Data;

@Data
public class Duck {
    public void quack() {};
    public void swim() {};
    public void display() {};
    public void fly() {
        System.out.println("此鸭子会飞");
    }
}
