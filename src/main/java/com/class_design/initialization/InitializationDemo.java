package com.class_design.initialization;

public class InitializationDemo {
    /*
        - Order of initialization
            - if there is a superclass, it is initialized first
            - all static variables are processed (in order of appearance)
            - all static initializers are processed (in order of appearance)

        - All this happens at most once for each class!
            - class is initialized automatically if main() method is inside the class,
              or manually by calling 'new MyClass();'

        - final instance variables assume the value by the time the constructor completes!
            (final local variables must have value only if used)

        - Order of initialization when creating an instance
            - Initialize the class if it was not already initialized
            - If there is a superclass, initialize superclass
            - Process all instance variable declarations
            - Process all instance initializers
            - Initialize the constructor


     */
}
