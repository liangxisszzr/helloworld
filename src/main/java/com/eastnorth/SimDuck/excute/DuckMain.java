package com.eastnorth.SimDuck.excute;

import com.eastnorth.SimDuck.StrategyPattern.behavier.FlyWithWing;
import com.eastnorth.SimDuck.StrategyPattern.behavier.Quack;
import com.eastnorth.SimDuck.StrategyPattern.duck.Duck;
import com.eastnorth.SimDuck.StrategyPattern.duck.MallardDuck;
import com.eastnorth.SimDuck.StrategyPattern.duck.RedHeadDuck;
import com.eastnorth.SimDuck.StrategyPattern.duck.RubberDuck;

public class DuckMain {
    public static void main(String[] args) {
        FlyWithWing flyWithWing = new FlyWithWing();
        Quack quack = new Quack();
        Duck redHeadDuck = new RedHeadDuck();
        Duck mallardDuck = new MallardDuck();
        Duck rubberDuck = new RubberDuck();
        mallardDuck.setFlyBehavior(flyWithWing);
        mallardDuck.setQuackBehavior(quack);
        mallardDuck.performFly();
        mallardDuck.performQuack();
        mallardDuck.display();
        mallardDuck.swim();
    }
}
