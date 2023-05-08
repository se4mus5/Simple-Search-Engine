package search;

import search.logic.*;

import java.util.*;

public class Helpers {
    static Map<String, Set<Integer>> buildInvertedIndex(List<String> lines) {
        Map<String, Set<Integer>> invertedIndex = new HashMap<>();
        for (int i = 0; i < lines.size(); i++) {
            String[] words = lines.get(i).split("\\s+");
            for (String word : words) {
                if (invertedIndex.containsKey(word.toLowerCase())) {
                    invertedIndex.get(word.toLowerCase()).add(i);
                } else {
                    Set<Integer> locations = new HashSet<>();
                    locations.add(i);
                    invertedIndex.put(word.toLowerCase(), locations);
                }
            }
        }
        return invertedIndex;
    }

    static void findPerson(List<String> lines, Scanner scanner, Map<String, Set<Integer>> invertedIndex) {
        System.out.println("Select a matching strategy: ALL, ANY, NONE");
        MatchingStrategy matchingStrategy = MatchingStrategy.valueOf(scanner.nextLine());

        System.out.println("Enter a name or email to search all suitable people.");
        String searchPattern = scanner.nextLine().trim();

        Finder finder = new Finder();
        switch (matchingStrategy) {
            case ANY -> finder.setMethod(new AnyFindingMethod());
            case ALL -> finder.setMethod(new AllFindingMethod());
            case NONE -> finder.setMethod(new NoneFindingMethod());
        }
        finder.find(searchPattern, lines, invertedIndex);

        System.out.println();
    }

    static void printPeople(List<String> lines) {
        System.out.println("=== List of people ===");
        lines.forEach(System.out::println);
        System.out.println();
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
