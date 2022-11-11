package mianxiangduixiang;

public class Person {
    private int age;
    private String name;

    public Person() {
        this.eat();
    }

    public Person(int age) {
        this.age = age;
    }

    public Person(int age, String name) {
        this();
        this.age = age;
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public void eat(){
        System.out.println("吃");
    }
}
