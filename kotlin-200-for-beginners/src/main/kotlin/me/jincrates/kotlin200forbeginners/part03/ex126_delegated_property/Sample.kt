package me.jincrates.kotlin200forbeginners.part03.ex126_delegated_property

class Sample {
    var number: Int by OnlyPositive()
}
