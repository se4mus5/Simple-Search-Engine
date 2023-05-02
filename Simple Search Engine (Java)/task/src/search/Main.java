package search;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);

        //List<String> lines = dataEntry(scanner);
        List<String> lines = Files.readAllLines(new File(args[1]).toPath());

        int menuSelection;
        do {
            printMenu();
            menuSelection = Integer.parseInt(scanner.nextLine());
            switch (menuSelection) {
                case 1 -> findPerson(lines, scanner);
                case 2 -> printPeople(lines);
                case 0 -> System.out.println("Bye!");
                default -> System.out.println("Incorrect option! Try again.\n");
            }
        } while (menuSelection != 0);
    }

    private static void findPerson(List<String> lines, Scanner scanner) {
        System.out.println("Enter a name or email to search all suitable people.");
        String searchPattern = scanner.nextLine().trim();
        List<String> matches = new ArrayList<>();
        for (String line : lines) {
            if (line.toLowerCase().contains(searchPattern.toLowerCase())) {
                matches.add(line);
            }
        }
        if (matches.size() > 0) {
            //System.out.println("Found people:");
            matches.forEach(System.out::println);
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
