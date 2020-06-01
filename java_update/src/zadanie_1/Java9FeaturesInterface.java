package zadanie_1;
import java.util.List;

interface Java9FeaturesInterface {
    private List<Integer> getMockedList() {
        return List.of(-4, -3, 3, -1, 4, 1, 2);
    }

    default void printFirstPositiveNumber() {
        System.out.print(getMockedList()
                .stream()
                .filter(number -> number >= 0)
                .findFirst()
                .get());
    }
}
