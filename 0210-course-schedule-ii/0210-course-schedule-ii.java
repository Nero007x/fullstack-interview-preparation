import java.util.*;

public class Solution {

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        // Build prerequisite map
        Map<Integer, List<Integer>> preMap = new HashMap<>();
        for (int i = 0; i < numCourses; i++) {
            preMap.put(i, new ArrayList<>());
        }

        for (int[] pair : prerequisites) {
            int course = pair[0];
            int prereq = pair[1];
            preMap.get(course).add(prereq);
        }

        // For DFS and cycle detection
        Set<Integer> visiting = new HashSet<>();
        Set<Integer> visited = new HashSet<>();
        List<Integer> output = new ArrayList<>();

        for (int course = 0; course < numCourses; course++) {
            if (!dfs(course, preMap, visiting, visited, output)) {
                return new int[0]; // cycle detected
            }
        }

        // Output is in reverse post-order
        int[] result = new int[output.size()];
        for (int i = 0; i < output.size(); i++) {
            result[i] = output.get(i);
        }
        return result;
    }

    private boolean dfs(int course, Map<Integer, List<Integer>> preMap,
                        Set<Integer> visiting, Set<Integer> visited, List<Integer> output) {
        if (visiting.contains(course)) {
            return false; // cycle detected
        }
        if (visited.contains(course)) {
            return true;
        }

        visiting.add(course);

        for (int prereq : preMap.get(course)) {
            if (!dfs(prereq, preMap, visiting, visited, output)) {
                return false;
            }
        }

        visiting.remove(course);
        visited.add(course);
        output.add(course); // post-order for topological sort

        return true;
    }
}
