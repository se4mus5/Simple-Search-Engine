package search.logic;

import java.util.List;
import java.util.Map;
import java.util.Set;

public interface FindingMethod {
    // TODO remove duplicate code across find implementations
    void find(String searchPattern, List<String> lines, Map<String, Set<Integer>> invertedIndex);
}
