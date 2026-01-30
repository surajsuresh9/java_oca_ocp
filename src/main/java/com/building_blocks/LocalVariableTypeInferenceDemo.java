package com.building_blocks;

public class LocalVariableTypeInferenceDemo {

    /*
            - LocalVariableTypeInference
                - introduced in JDK 10
                - local variable = can be used only with local variables
                - type inference - this type of the variable is inferred by the compiler
                    var a = 5;
                    // a is inferred to be of type int
                    var a = "John Wayne"; // DOES NOT COMPILE

                    // you can't assign nul to LVTI (it's impossible to infer type)
                    var s = null; // DOES NOT COMPILE

                    // var is NPT the reserved keyword (backward compatibility)
                    public class var{} // OK
                    var var = 5; // OK
                    Var var = new Var(); // OK

                    // only local variables
                    public int sum(var a, var b){
                        int res = a + b;
                        return res;
                    } // DOES NOT COMPILE

                    // practical usage
                    // old way
                    ClassWithVeryVeryLongName myInstance = new ClassWithVeryVeryLongName();

                    // new way
                    var myInstance = new ClassWithVeryVeryLongName();

     */
}
