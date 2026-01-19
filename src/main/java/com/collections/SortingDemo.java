package com.collections;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class SortingDemo {
    /*
            - Sorting data in a collection
                - if elements are primitives, they are sorted by natural order
                - if elements are Strings, then numbers sort before letters, and uppercase letters sort before lowercase
                - but if elements are user defined objects, a custom criteria needs to be defined
                    - in order to do this, one of 2 approaches must be followed
                        - use a class which implements Comparable<T> interface
                        - pass the implements of Comparator<T> interface in sort method

            - Comparable<T> interface
                - this interface has one abstract method: int compareTo(T o)
                    - this method has to be implemented ina  concrete class
                        - this method returns according to the following rules
                            - if currObj is equal to args it returns 0
                            - if currObj is greater than args it returns +ve number
                            - if currObj is lesser than args it returns -ve number

           - Comparator<T> interface
                - if we want to sort by multiple criteria, we can use Comparator<T> interface
                    - we need to provide implementation of compare(T o1, T o2) method
                    - this implementation is passed to sort method


     */
    public static void main(String[] args) {
        Person p1 = new Person("John", 21);
        Person p2 = new Person("George", 23);
        Person p3 = new Person("Ben", 22);
        List<Person> persons = Arrays.asList(p1, p2, p3);

        System.out.println("Comparable sort");
        System.out.println(persons);
        Collections.sort(persons);
        System.out.println(persons);

        System.out.println("Comparator sort - lambda");
        Collections.sort(persons, (o1, o2) -> o1.getAge() - o2.getAge());
        System.out.println(persons);
        Collections.sort(persons, (o1, o2) -> o1.getName().compareTo(o2.getName()));
        System.out.println(persons);

        System.out.println("Comparator sort - inner anonymous class");
        Comparator<Person> byAge = new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                return o1.getAge() - o2.getAge();
            }
        };
        Collections.sort(persons, byAge);
        System.out.println(persons);

        // using comparing() method with method reference

        // to sort by name
        Comparator<Person> c = Comparator.comparing(Person::getAge);

        // to sort by name in reverse order
        Comparator<Person> cReverse = Comparator.comparing(Person::getAge).reversed();

        // to sort by name and then age (if names are same)
        c = Comparator.comparing(Person::getName).thenComparing(Person::getAge);


    }


}


class Person implements Comparable<Person> {
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

//    @Override
//    public int compareTo(Person o) {
//        return this.age - o.age;
//    }

    @Override
    public int compareTo(Person o) {
        return this.name.compareTo(o.name);
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "Person{" + "name='" + name + '\'' + ", age=" + age + '}';
    }
}
