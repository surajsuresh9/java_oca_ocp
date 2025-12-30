package com.beyond_classes.record;

import java.util.Objects;

// old way
public final class Student {

    // 1. declare private final fields
    private final String firstName;
    private final String lastName;
    private final int id;

    // 2. define the constructor
    public Student(String firstName, String lastName, int id) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.id = id;
    }

    // 3. define getters


    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getId() {
        return id;
    }

    // 4. Override toString()

    @Override
    public String toString() {
        return "Student{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", id=" + id +
                '}';
    }

    // 5. override equals()
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student s = (Student) o;
        return getId() == s.getId() &&
                Objects.equals(getFirstName(), s.getFirstName()) &&
                Objects.equals(getLastName(), s.getLastName());
    }

    // 6. override hashCode
    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, id);
    }
}
