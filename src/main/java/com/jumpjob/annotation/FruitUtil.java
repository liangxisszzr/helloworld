package com.jumpjob.annotation;

import java.lang.reflect.Field;

/**
 * @Auther: zuojianhou
 * @Date: 2020/12/14
 * @Description:
 */
public class FruitUtil {
    public static void getFruit(Class<?> clazz) {
        StringBuilder fruitName = new StringBuilder("水果名称：");
        String fruitColor = "水果颜色：";
        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) {
            if (field.isAnnotationPresent(FruitName.class)) {
                FruitName fruitName1 = field.getAnnotation(FruitName.class);
                fruitName.append(fruitName1.value());
            }
            if (field.isAnnotationPresent(FruitColor.class)) {
                FruitColor fruitColor1 = field.getAnnotation(FruitColor.class);
                fruitColor = fruitColor + fruitColor1.fruitColor();
            }
        }
        System.out.println(fruitName + fruitColor);
    }
}
