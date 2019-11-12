package com.eastnorth.StrategyPattern.duck;

import com.eastnorth.StrategyPattern.behavier.FlyWithWing;
import com.eastnorth.StrategyPattern.behavier.Quack;
import lombok.Data;

@Data
public class MallardDuck extends Duck {

    /**
     * 构造绿头鸭子
     */
    public MallardDuck() {
        flyBehavior = new FlyWithWing();
        quackBehavior = new Quack();
    }

    /**
     * 重写外貌表现
     */
    @Override
    public void display() {
        System.out.println("绿头鸭子");
    }
}
