package search;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);

        //List<String> lines = dataEntry(scanner);
        List<String> lines = Files.readAllLines(new File(args[1]).toPath());
        Map<String, List<Integer>> invertedIndex = buildInvertedIndex(lines);

        int menuSelection;
        do {
            printMenu();
            menuSelection = Integer.parseInt(scanner.nextLine());
            switch (menuSelection) {
                case 1 -> findPerson(lines, scanner, invertedIndex);
                case 2 -> printPeople(lines);
                case 0 -> System.out.println("Bye!");
                default -> System.out.println("Incorrect option! Try again.\n");
            }
        } while (menuSelection != 0);
    }

    private static Map<String, List<Integer>> buildInvertedIndex(List<String> lines) {
        Map<String, List<Integer>> invertedIndex = new HashMap<>();
        for (int i = 0; i < lines.size(); i++) {
            String[] words = lines.get(i).split("\\s+");
            for (String word : words) {
                if (invertedIndex.containsKey(word)) {
                    invertedIndex.get(word).add(i);
                } else {
                    List<Integer> locations = new ArrayList<>();
                    locations.add(i);
                    invertedIndex.put(word, locations);
                }
            }
        }
        return invertedIndex;
    }

    private static void findPerson(List<String> lines, Scanner scanner, Map<String, List<Integer>> invertedIndex) {
        System.out.println("Enter a name or email to search all suitable people.");
        String searchPattern = scanner.nextLine().trim();

        if (invertedIndex.containsKey(searchPattern)) {
            System.out.printf("%d persons found:%n", invertedIndex.get(searchPattern).size());

            for (int lineNumber : invertedIndex.get(searchPattern)) {
                System.out.println(lines.get(lineNumber));
            }
        } else {
            System.out.println("No matching people found.");
        }
        System.out.println();
    }

    private static void printPeople(List<String> lines) {
        System.out.println("=== List of people ===");
        lines.forEach(System.out::println);
        System.out.println();
    }

    public static List<String> dataEntry(Scanner scanner) {
        List<String> lines = new ArrayList<>();
        System.out.println("Enter the number of people:");
        int entries = Integer.parseInt(scanner.nextLine());
        System.out.println("Enter all people:");
        for (int i = 0; i < entries; i++) {
            lines.add(scanner.nextLine());
        }
        System.out.println();

        return lines;
    }

    public static void printMenu() {
        System.out.println("""
                === Menu ===
                1. Find a person
                2. Print all people
                0. Exit
                """);
    }
}
