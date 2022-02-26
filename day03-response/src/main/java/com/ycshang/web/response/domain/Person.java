package com.ycshang.web.response.domain;

/**
 * @program: 03-Servlet
 * @description:
 * @author: ycshang
 * @create: 2022-02-25 16:31
 **/
public class Person {
    private String name;
    private String sex;
    private String phone;

    public Person(String name, String sex, String phone) {
        this.name = name;
        this.sex = sex;
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}