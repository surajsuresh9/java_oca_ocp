package com.beyond_classes.polymorphism;

public class PolymorphismDemo {
    /*
        Polymorphism
          - property of an object to take many different forms (poly = many, morph = form)
          - to access a Java object, we have to have a reference pointing to that obj
          - there are 3 ways to access the Java obj
            - using reference with same type as the obj
            - using reference that is superclass of the obj
            - using interface reference

          - once you create a new reference, only members
            of that reference type are accessible via the reference

          - CanRun shihTzu = new ShihTzu(); // OK
            System.out.println(shihTzu.weight); // weight is NOT a member of canRun interface

          - Dog shihTzu = new ShihTzu(); // OK
            System.out.println(shihTzu.canRunFast()); // canRunFast is NOT a member of Dog

          - Object vs Reference
            - the type of object determines which properties exits within
              the object in memory
            - the type of reference to teh object determines which methods and
              variables are accessible to the Java program

              Reference             Object in memory
              ----------------------------------------
                shithTzu            weight = 6
                dog                 canRun()
                canRun              canRunFast()

            - Casting Objects
                - ShihTzu shihTzu = new ShihTzu();
                  Dog dog = shihTzu; // implicit cast to supertype, OK

                - ShihTzu shihTzu2 =  (ShihTzu) dog; // explicit cast to subtype, OK

                - ShihTzu shihTzu3 =  dog; // ClassCastException ;you CANNOT put larger in smaller without explicit cast

     */
}
