package dev.jacaro.school.cs4308.example;


import java.util.Objects;

/**
 * Example execution program. Executes all three provided files.
 */
public class Main {

    public static void main(String[] args) {
        dev.jacaro.school.cs4308.Main.main(
                new String[] {
                        "--debug-scanner",
                        "--debug-parser",
//                        Objects.requireNonNull(ClassLoader.getSystemClassLoader().getResource("dev/jacaro/school/sc4308/example/ex1.txt")).getPath(),
//                        Objects.requireNonNull(ClassLoader.getSystemClassLoader().getResource("dev/jacaro/school/sc4308/example/ex2.txt")).getPath(),
//                        Objects.requireNonNull(ClassLoader.getSystemClassLoader().getResource("dev/jacaro/school/sc4308/example/ex3.txt")).getPath(),
                        Objects.requireNonNull(ClassLoader.getSystemClassLoader().getResource("dev/jacaro/school/sc4308/example/ex4.txt")).getPath(),
                });

    }
}
