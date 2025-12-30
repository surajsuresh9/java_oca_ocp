package com.abstract_interfaces;

public class AbstractClassDemo {
    /*
        - classes which can be extended, but can't be initialized

        - Abstract Methods
            - marked with abstract keyword
            - doesn't have a body
            - the implementation (body) is done in classes which extend
              an abstract class

        - Rules for using abstract methods
            - Only instance methods can be marked abstract
                - not variables, constructors, static methods
            - Abstract method can only be declared in an abstract class
            - Non-abstract class which extends abstract class must implement all inherited methods
            - All other with overriding methods apply

            - Abstract classes can have constructors
                - but they can only be called using super() from the child class
                - abstract class or method cannot be marked final (wouldn't make any sense)
                - abstract methods cannot be marked private
                - static methods cannot be overridden, therefore



     */
}
