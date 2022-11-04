package me.jincrates.kotlin200forbeginners.part02_intermediate_grammar.ex058_property_getter_setter

class Person {

    var age: Int = 0
        get() {
            return field
        }
        set(value) {
            field = if(value >= 0) value else 0
        }
}