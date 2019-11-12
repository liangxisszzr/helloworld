package com.eastnorth.StrategyPattern.duck;

import com.eastnorth.StrategyPattern.behavier.FlyBehavior;
import com.eastnorth.StrategyPattern.behavier.QuackBehavior;
import lombok.Data;

/**
 * @desc:鸭子类
 * @author zuojianhou
 * @date 2019/11/12 19:25
 */
@Data
public class Duck {

    /**
     * 飞行行为（变动大用接口实现）
     */
    FlyBehavior flyBehavior;

    /**
     * 鸣声行为（变动大用接口实现）
     */
    QuackBehavior quackBehavior;

    /**
     * 游泳行为（无变动可直接写在类里）
     */
    public void swim() {
        System.out.println("我会游泳!");
    }

    /**
     * 外貌表现继承时重写
     */
    public void display() {}

    /**
     * 实现飞行方法
     */
    public void performFly() {
        flyBehavior.fly();
    }

    /**
     * 实现鸣声行为
     */
    public void performQuack() {
        quackBehavior.quack();
    }
}
