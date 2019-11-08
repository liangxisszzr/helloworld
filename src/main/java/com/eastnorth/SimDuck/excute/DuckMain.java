package com.eastnorth.SimDuck.excute;

import com.eastnorth.SimDuck.duck.Duck;
import com.eastnorth.SimDuck.duck.MallardDuck;
import com.eastnorth.SimDuck.duck.RedHeadDuck;
import com.eastnorth.SimDuck.duck.RubberDuck;

public class DuckMain {
    public static void main(String[] args) {
        Duck redHeadDuck = new RedHeadDuck();
        Duck mallardDuck = new MallardDuck();
        Duck rubberDuck = new RubberDuck();
        redHeadDuck.display();
        mallardDuck.display();
        rubberDuck.quack();
        rubberDuck.display();
    }
}
