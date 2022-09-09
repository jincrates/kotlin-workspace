package me.jincrates.kotlin200forbeginners.part03_advanced_grammar.ex115_generic_specific_type

interface ValueContainer {
    fun getValue(): Int
}

class AAA: ValueContainer {
    override fun getValue(): Int  = 1102
}

class BBB: ValueContainer {
    override fun getValue(): Int = 127
}

