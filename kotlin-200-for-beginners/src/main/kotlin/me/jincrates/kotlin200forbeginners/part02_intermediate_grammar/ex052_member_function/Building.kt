package me.jincrates.kotlin200forbeginners.part02_intermediate_grammar.ex052_member_function;

class Building  {
    var name = ""  // 건물명
    var date = ""  // 건축일자
    var area = 0   // 면적(m²)

    fun print() {
        println("이름: ${this.name}")
        println("건축일자: ${this.date}")
        println("면적: ${this.area} m²")
    }
}
