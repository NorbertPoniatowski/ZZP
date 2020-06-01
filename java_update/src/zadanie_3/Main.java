package zadanie_3;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {
        System.out.println("Zadanie 3:");

        System.out.println("\"\".isBlank(): (" + "".isBlank() + ")");

        System.out.println("\"\".isEmpty(): (" + "".isEmpty() + ")");

        Stream<String> lines = "AB\nAB\nAB".lines();
        System.out.println("\"AB\\nAB\\nAB\".lines(): (" + lines + ") " + lines.collect(Collectors.toList()));

        System.out.println("\" DB \".strip(): (" + " DB ".strip() + ")");

        System.out.println("\" DB \".stripLeading(): (" + " DB ".stripLeading() + ")");

        System.out.println("\" DB \".stripTrailing(): (" + " DB ".stripTrailing() + ")");

        System.out.println("\"==\".repeat(5): (" + "==".repeat(5) + ")");
    }
}
