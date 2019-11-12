package com.eastnorth.StrategyPattern.SimDuck;

import com.eastnorth.StrategyPattern.behavier.*;
import com.eastnorth.StrategyPattern.duck.Duck;
import com.eastnorth.StrategyPattern.duck.MallardDuck;
import com.eastnorth.StrategyPattern.duck.RedHeadDuck;
import com.eastnorth.StrategyPattern.duck.RubberDuck;

public class DuckMain {
    public static void main(String[] args) {
        FlyWithWing flyWithWing = new FlyWithWing();
        Quack quack = new Quack();
        FlyNoWay flyNoWay = new FlyNoWay();
        RocketFly rocketFly = new RocketFly();
        MuteQuack muteQuack = new MuteQuack();
        Squeak squeak = new Squeak();
        Duck redHeadDuck = new RedHeadDuck();
        Duck mallardDuck = new MallardDuck();
        Duck rubberDuck = new RubberDuck();
        mallardDuck.setFlyBehavior(flyWithWing);
        mallardDuck.setQuackBehavior(quack);
        redHeadDuck.setFlyBehavior(rocketFly);
        redHeadDuck.setQuackBehavior(squeak);
        rubberDuck.setFlyBehavior(flyNoWay);
        rubberDuck.setQuackBehavior(muteQuack);
        mallardDuck.performFly();
        mallardDuck.performQuack();
        mallardDuck.display();
        mallardDuck.swim();
        redHeadDuck.display();
        redHeadDuck.performFly();
        redHeadDuck.performQuack();
        redHeadDuck.swim();
        rubberDuck.swim();
        rubberDuck.performQuack();
        rubberDuck.performFly();
        rubberDuck.display();
    }
}
