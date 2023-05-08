package search;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);

        List<String> lines = Files.readAllLines(new File(args[1]).toPath());
        Map<String, Set<Integer>> invertedIndex = Helpers.buildInvertedIndex(lines);

        int menuSelection;
        do {
            Helpers.printMenu();
            menuSelection = Integer.parseInt(scanner.nextLine());
            switch (menuSelection) {
                case 1 -> Helpers.findPerson(lines, scanner, invertedIndex); // uses the Strategy pattern
                case 2 -> Helpers.printPeople(lines);
                case 0 -> System.out.println("Bye!");
                default -> System.out.println("Incorrect option! Try again.\n");
            }
        } while (menuSelection != 0);
    }

}
