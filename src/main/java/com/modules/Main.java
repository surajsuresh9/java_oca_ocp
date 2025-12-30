package com.modules;

import java.awt.image.BufferedImage;

public class Main {
    public static void main(String[] args) {
        var x = "hello";
        System.out.println("Class: " + x.getClass());
        System.out.println("Module: " + x.getClass().getModule());

        var bufferedImage = new BufferedImage(2, 1, 1);
        /* This is acting like an unnamed module, so it can access all named
           modules with needing to declare dependencies explicitly

           But if this was a named module/ modular project, then the
           'requires java.desktop' would be mandatory or less it cannot access the
           BufferedImage class

        */

    }
}
