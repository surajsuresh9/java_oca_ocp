package com.methods.static_modifier;

public class MetalBlock {
    private static final double MASS_IN_KILOS;
    private static final double VOLUME_IN_CUBIC_METERS;
    private static final double DENSITY_IN_KILOS_PER_CUBIC_METER;

    // executed first 1
    static {
        MASS_IN_KILOS = 100;
        VOLUME_IN_CUBIC_METERS = 0.01;
    }

    // executed second 2
    static {
        DENSITY_IN_KILOS_PER_CUBIC_METER = MASS_IN_KILOS / VOLUME_IN_CUBIC_METERS;
    }

    public static void main(String[] args) {
        System.out.println("DENSITY_IN_KILOS_PER_CUBIC_METER: " + MetalBlock.DENSITY_IN_KILOS_PER_CUBIC_METER);
    }
}
