package com.abstract_interfaces.interfaces;

public class InterfaceDemo {
    /*
          - Interfaces
            - A class can extend only 1 class
            - If we want to extend more (abstract) classes, then we use interfaces
            - Similar to abstract classes
            - A class can implement any number of interfaces
            - Keyword implements, separated by comma (,)
            - Like abstract, an instance of an interface cannot be created using 'new' keyword
            - All interfaces are implicitly abstract, so they can't be marked final

          - Rules of implementation
            - Overriding rules
                - keyword public is required
                - return types must be covariant with the interface method
                - signature (name & method) must match the interface method
            - all inherited methods must be implemented
            - an interface can extend another interface

          - Default Interface Methods
            - imagine an interface implemented by 100 classes
              if another method is added to this interface, if this method was abstract
              then this would've had to be implemented in 100 classes.
              This is solved by making the method default (non-abstract)
            - default method must have a body (default implementation)

          - Rules for using default methods
            - keyword default with a method can only be used in the interface
            - has to have a body (default implementation)
            - implicitly public
            - cannot be abstract, final or static
            - may or may not be overridden by a class implementing the interface
            - if teh class inherits 2 or more default methods with the same method signature then it must override the method

          - static interface methods
            - static methods cannot be overridden

          - private interface methods
            - cannot be overridden

          - Rules for using private interface methods
            - marked with keyword private
            - must have a body
            - private static methods can be called by any methods in the interface
            - non-static private methods may be called by non-static methods

          - default and private non-static methods can call abstract methods

     */
}
