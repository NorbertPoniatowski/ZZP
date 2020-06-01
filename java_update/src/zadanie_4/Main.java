package zadanie_4;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Main {

    public static void main(String[] args) throws IOException {
        System.out.println("Zadanie 4:");

        Path path1 = Files.writeString(Files.createTempFile("example1", ".txt"), "Example text");
        Path path2 = Files.writeString(Files.createTempFile("example2", ".txt"), "Example text");
        Path path3 = Files.writeString(Files.createTempFile("example3", ".txt"), "ExampleText");

        System.out.println(Files.mismatch(path1, path2));
        System.out.println(Files.mismatch(path1, path3));

        System.out.println(Files.readString(path1));
        System.out.println(Files.readString(path2));
        System.out.println(Files.readString(path3));
    }
}
