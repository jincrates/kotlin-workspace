package me.jincrates.kotlin200forbeginners.part03.ex114_inherit_from_generic

interface Plusable<T> {

    operator  fun plus(other: T): T
}