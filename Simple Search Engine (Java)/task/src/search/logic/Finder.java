package search.logic;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class Finder {
    private FindingMethod method;

    public void setMethod(FindingMethod method) {
        this.method = method;
    }

    // Strategy Pattern
    public void find(String searchPattern, List<String> lines, Map<String, Set<Integer>> invertedIndex) {
        this.method.find(searchPattern, lines, invertedIndex);
    }
}
