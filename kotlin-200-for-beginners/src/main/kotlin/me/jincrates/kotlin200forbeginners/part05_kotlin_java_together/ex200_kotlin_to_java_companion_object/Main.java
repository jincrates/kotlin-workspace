package me.jincrates.kotlin200forbeginners.part05_kotlin_java_together.ex200_kotlin_to_java_companion_object;

public class Main {

    public static void main(String[] args) {
        KotlinClass.Companion.setNum(30);
        System.out.println(KotlinClass.Companion.getNum());
        KotlinClass.Companion.hello();
    }
}
