package me.jincrates.kotlin200forbeginners.part04_kotlin_standard_library.ex186_file_tree_walk_class;

import java.io.File

/*
186. FieTreeWalk 클래스: 디렉토리 순회하기
FileTreeWalk 클래스는 Sequence<File>을 구현하는 클래스이며, 반복자를 이용해 특정 디렉토리의 하위 파일과 하위 디렉토리들을 순회할 수 있다.
 */
fun main(args:Array<String>): Unit {

    val fileTree: FileTreeWalk = File("./").walk()
            .maxDepth(3)
            .onEnter { file ->
                println("새 디렉토리 방문: ${file.name}")
                true
            }

    for (file in fileTree) {
        println(file.name)
    }
}