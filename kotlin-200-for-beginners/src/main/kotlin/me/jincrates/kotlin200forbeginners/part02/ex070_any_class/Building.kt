package me.jincrates.kotlin200forbeginners.part02.ex070_any_class

class Building(
    val name: String = "",  // 건물명
    val date: String = "",  // 건출일자
    val area: Int = 0       // 면적(m²)
) {
    override fun toString() =
            "이름: ${this.name}\n" +
            "건축일자: ${this.date}\n" +
            "면적: ${this.area} m²"
}