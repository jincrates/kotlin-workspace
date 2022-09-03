package me.jincrates.kotlin200forbeginners.part01;

/*
041. 소스 파일 여러 개로 분리하기
서로 관련 있는 함수끼리 묶어 하나의 파일로 추출해두면, 나중에 관리하기 편하다.
또한 프로그램을 개발하다가 소스코드를 재사용하기도 쉬워진다.

프로그램이 더 커지면 패키지로도 나누는데, 클래스 이름과 혼동되지 않도록
패키지명칭은 소문자로 짓는 것이 일반적이다.
 */
fun main(args:Array<String>): Unit {
    val a = 20
    val b = -30
    println(max(a, abs(b)))
}