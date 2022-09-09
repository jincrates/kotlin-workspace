package me.jincrates.kotlin200forbeginners.part03_advanced_grammar.ex113_generic_to_class_and_interface

class Pair<A, B>(val first: A, val second: B) {
    override fun toString() = "$first\n$second"
}