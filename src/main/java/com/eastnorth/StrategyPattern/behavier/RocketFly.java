package com.eastnorth.StrategyPattern.behavier;

/**
 * 恶搞火箭飞行器
 */
public class RocketFly implements FlyBehavior {
    public void fly() {
        System.out.println("报告长官，火箭飞行已就绪！");
    }
}
