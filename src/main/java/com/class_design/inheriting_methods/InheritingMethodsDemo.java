package com.class_design.inheriting_methods;

public class InheritingMethodsDemo {
/*
    - subclass can override an inherited method
        - subclass declares a new implementation for an
           inherited method with same signature (name & parameters)
           and covariant return type
       - the property of the object to take many different forms is called polymorphism

     - Overridden method must have the same signature sa superclass method
     - Overridden method must be at least as accessible as the original method
     - Overridden method may not declare a checked exception that is new or broader than the one
       in the original method
     - Return type of the overridden method must be the same or a subtype
       of the return type of teh original method (covariant return types)

       // covariant return types

    - Overriding private and static methods
        - If the method is private, it's not visible to other classes
            - The method with the same signature in the subclass
              is independent of that method in the superclass 
            - This is not overriding, it's a completely different method
        
        - If the method is static, 'overridden' method must also be declared static
            - This is not overriding, since the method belongs to its own class
            - This is called hiding the method
            - Methods marked final cannot be overridden/ hidden

*/
}
