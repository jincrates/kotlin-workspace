package me.jincrates.issueservicekotlin.domain.enums

enum class IssueType {

    BUG, TASK;

    //외부에서 사용하도록 정적 팩토리 함수 생성
    /*
    companion object {
        fun of(type:String) = valueOf(type.uppercase())
    }
    */

    //생성자를 사용한 것처럼 사용할 수 있다. 코틀린 기능
    //IssueType("BUG")
    companion object {
        operator fun invoke(type: String) = valueOf(type.uppercase())
    }
}
