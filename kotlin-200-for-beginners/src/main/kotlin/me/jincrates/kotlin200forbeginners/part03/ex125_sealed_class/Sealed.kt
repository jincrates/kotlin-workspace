package me.jincrates.kotlin200forbeginners.part03.ex125_sealed_class

sealed class Outer {

    class One: Outer()
    class Two: Outer()
    class Three: Outer()
}