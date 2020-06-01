package zadanie_2;

import java.util.List;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        System.out.println("Zadanie 2:");

        var integerList = List.of(-4, -3, 3, -1, 4, 1, 2);
        List<Integer> positiveNumbers = integerList.stream()
                .filter(number -> number >= 0)
                .collect(Collectors.toUnmodifiableList());

        try {
            positiveNumbers.add(10);
        }
        catch (UnsupportedOperationException e) {
            e.printStackTrace();
        }

        System.out.println(positiveNumbers);
    }
}
