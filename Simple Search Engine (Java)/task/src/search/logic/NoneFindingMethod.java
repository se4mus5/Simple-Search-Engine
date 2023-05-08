package search.logic;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class NoneFindingMethod implements FindingMethod {

    @Override
    public void find(String searchPattern, List<String> lines, Map<String, Set<Integer>> invertedIndex) {
        String[] patterns = searchPattern.split("\\s+");

        // create a set of all line numbers
        Set<Integer> lineNumbers = new HashSet<>();
        for (Set <Integer> values : invertedIndex.values()) {
            lineNumbers.addAll(values);
        }

        // remove each pattern's matching lines
        for (String pattern : patterns) {
            if (invertedIndex.containsKey(pattern.toLowerCase())) {
                lineNumbers.removeAll(invertedIndex.get(pattern.toLowerCase()));
            }
        }

        // print remaining lines
        if (!lineNumbers.isEmpty()) {
            System.out.printf("%d persons found:%n", lineNumbers.size());
            lineNumbers.forEach(n -> System.out.println(lines.get(n)));
        } else {
            System.out.println("No matching people found.");
        }
    }
}
