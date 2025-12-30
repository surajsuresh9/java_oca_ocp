package com.beyond_classes.sealed_class;

public sealed class Car permits Ford, Renault, Fiat {
}


final class Ford extends Car {
}

non-sealed class Renault extends Car {
}

sealed class Fiat extends Car permits Uno, Punto {
}

final class Uno extends Fiat {
}

non-sealed class Punto extends Fiat {
}