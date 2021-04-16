package com.jumpjob.annotation;

/**
 * @author zuojianhou
 * @Date: 2020/12/14
 * @Description:
 */
public class Apple {
    @FruitName("xxx")
    private String appleName;

    @FruitColor
    private String appleColor;

    public String getAppleColor() {
        return appleColor;
    }

    public String getAppleName() {
        return appleName;
    }

    public void setAppleColor(String appleColor) {
        this.appleColor = appleColor;
    }

    public void setAppleName(String appleName) {
        this.appleName = appleName;
    }
}
