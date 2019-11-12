package com.eastnorth.StrategyPattern.duck;

import com.eastnorth.StrategyPattern.behavier.RocketFly;
import com.eastnorth.StrategyPattern.behavier.Squeak;
import lombok.Data;

@Data
public class RedHeadDuck extends Duck {

    /**
     * 构造红头鸭子
     */
    public RedHeadDuck() {
        flyBehavior = new RocketFly();
        quackBehavior = new Squeak();
    }

    /**
     * 重写外貌表现
     */
    @Override
    public void display() {
        System.out.println("红头鸭子");
    }
}
