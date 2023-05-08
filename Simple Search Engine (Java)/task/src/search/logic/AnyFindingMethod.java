package search.logic;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class AnyFindingMethod implements FindingMethod {

    @Override
    public void find(String searchPattern, List<String> lines, Map<String, Set<Integer>> invertedIndex) {
        List <String> linesFound = new ArrayList<>();
        for (String p : searchPattern.split("\\s+")) {
            if (invertedIndex.containsKey(p)) {
                Set<Integer> lineContainsElementsOfPattern = invertedIndex.get(p);
                for (int lineNumber : lineContainsElementsOfPattern) {
                    linesFound.add(lines.get(lineNumber));
                }
            }
        }

        if (!linesFound.isEmpty()) {
            System.out.printf("%d persons found:%n", linesFound.size());
            linesFound.forEach(System.out::println);
        } else {
            System.out.println("No matching people found.");
        }
    }
}
