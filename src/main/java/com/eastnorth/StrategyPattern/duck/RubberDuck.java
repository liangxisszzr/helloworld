package com.eastnorth.StrategyPattern.duck;

import com.eastnorth.StrategyPattern.behavier.FlyNoWay;
import com.eastnorth.StrategyPattern.behavier.MuteQuack;
import lombok.Data;

@Data
public class RubberDuck extends Duck {

    /**
     * 构造橡皮鸭子
     */
    public RubberDuck() {
        flyBehavior = new FlyNoWay();
        quackBehavior = new MuteQuack();
    }

    /**
     * 重写外貌表现
     */
    @Override
    public void display() {
        System.out.println("橡皮鸭子");
    }
}
