package com.beyond_classes.enums;

public class EnumDemo {
    /*
        - Enum (enumeration) is a fixed set of constants
        - Enum provides type-safe checking
            - it's impossible to create an invalid enum value
        - Can have constructors and instance methods
        - Enum constructors are private by default
        - Enums can implement abstract methods
        - Methods can be overridden by certain enums only
        - Enums cannot extend a class, but can implement an interface
     */

    public static void main(String[] args) {
        Compass N = Compass.NORTH;
        System.out.println(Compass.NORTH.getInstruction());
        System.out.println(N);
        System.out.println(N == Compass.NORTH);

        for (Compass direction : Compass.values()) {
            System.out.println(direction.ordinal() + ": " + direction.name() + ": " + direction.getInstruction());
        }

        switch (N) {
            case NORTH -> System.out.println("You are headed North");
            case EAST -> System.out.println("You are headed East");
            case WEST -> System.out.println("You are headed West");
            case SOUTH -> System.out.println("You are headed South");
        }

    }
}

enum Compass implements Planet {
    EAST("Move east") {
        @Override
        String getDirection() {
            return "East";
        }
    },

    NORTH("Move up") {
        @Override
        String getDirection() {
            return "Up";
        }
    },

    SOUTH("Move down") {
        @Override
        String getDirection() {
            return "Down";
        }
    },

    WEST("Move west") {
        @Override
        String getDirection() {
            return "West";
        }
    };

    @Override
    public String getPlanetName() {
        return "Earth";
    }

    private final String instruction;

    private Compass(String instruction) {
        this.instruction = instruction;
    }

    public String getInstruction() {
        return instruction;
    }

    abstract String getDirection();
}

interface Planet {
    String getPlanetName();
}
