package me.jincrates.kotlin200forbeginners.part03_advanced_grammar.ex127_class_delegation

class ClassDelegator : Plusable {
    override fun plus(other: Int): Int {
        println("기본 구현")
        return other
    }
}