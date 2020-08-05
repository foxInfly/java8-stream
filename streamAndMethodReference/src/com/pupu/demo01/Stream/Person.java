package com.pupu.demo01.Stream;


/**
 * @author : lipu
 * @since : 2020-08-05 23:00
 */
public class Person {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Person(String name) {
        this.name = name;
    }

//    public Person() {
//    }

    @Override
    public String toString() {
        return "Person{" +
                "name=" + name +
                '}';
    }
}
