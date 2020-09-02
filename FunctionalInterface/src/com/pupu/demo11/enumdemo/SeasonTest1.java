package com.pupu.demo11.enumdemo;

/**
 * 一、枚举类的使用
 * 1.枚举类的理解:类的对象只有有限个，确定的。我们称此类为枚举类
 * 2.当需要定义- 组常量时，强烈建议使用枚举类
 * 3.如果枚举类中只有一一个对象，则可以作为单例模式的实现方式。
 * 二、如何定义枚举类
 * 方式一: jdk5.0之前， 自定义枚举类
 * 方式二: jdk5.0， 可以使用enum关键字定义枚举类
 *
 * @author : lipu
 * @since : 2020-08-22 22:08
 */
public class SeasonTest1 {
    public static void main(String[] args) {
        String seasonDesc = Season1.AUTUMN.getSeasonDesc();
        String seasonName = Season1.AUTUMN.getSeasonName();
        Season1 spring = Season1.SPRING;
        System.out.println(spring);
        System.out.println(seasonName+":"+seasonDesc);

        System.out.println(Season1.class.getSuperclass());

        Season1[] season1s = Season1.values();
        for (Season1 season1 : season1s) {
            System.out.println(season1);
        }
        System.out.println(Season1.valueOf("SPRING"));
    }
}

//自定义枚举类
enum  Season1 {
    //1.枚举类的对象，多个对象之间用逗号隔开
    SPRING ("春天","穿暖花开"),
    SUMMER ("夏天","夏日炎炎"),
    AUTUMN ("秋天","秋高气爽"),
    WINTER("冬天","冰天雪地");
    //1.声明Seanson对象的属性 :private finale修饰
    private final String seasonName;
    private final String seasonDesc;

    //2.私有化的构造器

    Season1(String seasonName, String seasonDesc) {
        this.seasonName = seasonName;
        this.seasonDesc = seasonDesc;
    }
    //3.提供当前枚举类的多个对象：public static final的

    //4.其他诉求1：获取枚举类对象的属性

    public String getSeasonName() {
        return seasonName;
    }

    public String getSeasonDesc() {
        return seasonDesc;
    }
    //5.其他诉求2：获取tostring
//    @Override
//    public String toString() {
//        return "Season1{" +
//                "seasonName='" + seasonName + '\'' +
//                ", seasonDesc='" + seasonDesc + '\'' +
//                '}';
//    }
}
