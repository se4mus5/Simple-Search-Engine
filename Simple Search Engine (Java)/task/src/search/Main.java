package search;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        List<String> lines = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the number of people:");
        int entries = Integer.parseInt(scanner.nextLine());
        System.out.println("Enter all people:");
        for (int i = 0; i < entries; i++) {
            lines.add(scanner.nextLine());
        }
        System.out.println();

        System.out.println("Enter the number of search queries:");
        int queries = Integer.parseInt(scanner.nextLine());
        System.out.println();
        for (int i = 0; i < queries; i++) {
            System.out.println("Enter data to search people:");
            String searchPattern = scanner.nextLine().trim();
            List<String> matches = new ArrayList<>();
            for (String line : lines) {
                if (line.toLowerCase().contains(searchPattern.toLowerCase())) {
                    matches.add(line);
                }
            }
            if (matches.size() > 0) {
                System.out.println("Found people:");
                matches.forEach(System.out::println);
            } else {
                System.out.println("No matching people found.");
            }
            System.out.println();
        }
    }
}
