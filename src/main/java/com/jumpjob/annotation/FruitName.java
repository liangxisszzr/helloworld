package com.jumpjob.annotation;

import java.lang.annotation.*;

/**
 * @author zuojianhou
 * @Date: 2020/12/14
 * @Description:
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface FruitName {
    String value() default "";
}
