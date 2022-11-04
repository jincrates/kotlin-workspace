package me.jincrates.kotlin200forbeginners.part04_kotlin_standard_library.ex185_file_io;

import java.io.*

/*
185. 파일 입출력
코틀린의 파일 입출력은 근본적으로 자바 표준 라이브러리에 의존하며, 코틀린 확장 함수가 이를 보조하는 형태로 되어 있다.
따라서 코틀린에서 파일 입출력을 하면 JVM에 의존성이 생긴다.
 */
fun main(args:Array<String>): Unit {

    val file = File("./hello.txt")

    if (file.exists()) {
        file.createNewFile()
    }

    val outputStream: OutputStream = file.outputStream()
    outputStream.write(35)

    val osw: OutputStreamWriter = outputStream.writer()
    osw.write("파일 입출력")
    osw.close()

    val inputStream: InputStream = file.inputStream()
    println(inputStream.read())

    val isr: InputStreamReader = inputStream.reader()
    println(isr.readText())
    isr.close()
}