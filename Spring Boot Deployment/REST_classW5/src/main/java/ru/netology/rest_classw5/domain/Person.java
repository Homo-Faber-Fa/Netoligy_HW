package ru.netology.rest_classw5.domain;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class Person {
    @NotBlank
    @Size(min = 2, max = 20 )

    private String name;
    @Min(0)
    @Max(150)
    private int age;

    public Person() {
         }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {

        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {

        this.age = age;
    }

//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (!(o instanceof Person)) return false;
//
//        Person person = (Person) o;
//
//        if (getAge() != person.getAge()) return false;
//        return getName().equals(person.getName());
//    }

//    @Override
//    public int hashCode() {
//        int result = getName().hashCode();
//        result = 31 * result + getAge();
//        return result;
//    }
}
