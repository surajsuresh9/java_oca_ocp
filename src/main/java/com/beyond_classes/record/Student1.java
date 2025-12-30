package com.beyond_classes.record;

public record Student1(String firstName, String lastName, int id) {
// we can override auto generated constructor
// this is called canonical constructor

    // canonical constructor
//    public Student1(String firstName, String lastName, int id) {
//        if (id < 10 || id > 1_000_000) throw new IllegalArgumentException();
//        this.firstName = firstName;
//        this.lastName = lastName;
//        this.id = id;
//    }

    // compact constructor
    // compact constructor could contain any business logic
    public Student1 {
//        if (id < 10 || id > 1_000_000) throw new IllegalArgumentException();
        firstName = firstName.substring(0, 1).toUpperCase() + firstName.substring(1).toLowerCase();
        lastName = lastName.substring(0, 1).toUpperCase() + lastName.substring(1).toLowerCase();
    }
}

class Demo {
    public static void main(String[] args) {
        var student = new Student1("luka", "popov", 1);
        var student2 = new Student1("LUKA", "POPOV", 1);
        System.out.println("student: " + student);
        System.out.println("firstName: " + student.firstName());
        System.out.println("lastName: " + student.lastName());
        System.out.println("id: " + student.id());
        System.out.println(student == student2);
        System.out.println(student.equals(student2));
    }
}
