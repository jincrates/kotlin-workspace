package me.jincrates.kotlin200forbeginners.part03_advanced_grammar.ex125_sealed_class

sealed class Outer {

    class One: Outer()
    class Two: Outer()
    class Three: Outer()
}