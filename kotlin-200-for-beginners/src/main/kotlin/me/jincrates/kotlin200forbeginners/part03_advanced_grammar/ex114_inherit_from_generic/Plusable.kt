package me.jincrates.kotlin200forbeginners.part03_advanced_grammar.ex114_inherit_from_generic

interface Plusable<T> {

    operator  fun plus(other: T): T
}