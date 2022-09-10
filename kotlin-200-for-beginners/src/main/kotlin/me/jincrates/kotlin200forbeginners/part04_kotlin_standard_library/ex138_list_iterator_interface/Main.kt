package me.jincrates.kotlin200forbeginners.part04_kotlin_standard_library.ex138_list_iterator_interface;

/*
138. Listlterator 인터페이스 살펴보기
- hasPrevious(): 이전 원소가 존재하는지 여부를 반환한다.
- previous(): 이전 원소를 반환하고, ListIterator의 커서를 뒤로 한 칸 옮긴다.
- nextIndex(): 다음 원소의 인덱스를 반환한다. 커서를 옮기지는 않는다.
- previousIndex(): 이전 원소의 인덱스를 반환한다. 커서를 옮기지는 않는다.
 */
private fun moveToNext(iter: ListIterator<Int>) {
    print("${iter.hasPrevious()}, ")
    print("${iter.hasNext()}, ")
    print("${iter.previousIndex()}, ")
    print("${iter.nextIndex()}, ")
    println("${iter.next()}")
}

fun main(args:Array<String>): Unit {

    val iter: ListIterator<Int> = listOf(10, 20, 30).listIterator()

    moveToNext(iter)
    moveToNext(iter)
    moveToNext(iter)
}