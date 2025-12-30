package com.beyond_classes.sealed_class;

public sealed interface Mammal permits Cat, Dog, Eats {
}

non-sealed interface Eats extends Mammal {
}

final class Cat implements Mammal {
}

non-sealed class Dog implements Mammal {
}