package me.jincrates.kotlin200forbeginners.part03_advanced_grammar.ex126_delegated_property

class Sample {
    var number: Int by OnlyPositive()
}
