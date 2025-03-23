import java.util.*;

class Solution {
    public int[] minimumCost(int n, int[][] edges, int[][] queries) {
        Map<Integer, List<int[]>> graph = new HashMap<>();
        for (int i = 0; i < n; i++) {
            graph.put(i, new ArrayList<>());
        }
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            int w = edge[2];
            graph.get(u).add(new int[]{v, w});
            graph.get(v).add(new int[]{u, w});
        }

        int[] component = new int[n];
        Arrays.fill(component, -1);
        Map<Integer, Integer> componentMinAnd = new HashMap<>();
        int compId = 0;

        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();

        for (int startNode = 0; startNode < n; startNode++) {
            if (component[startNode] == -1) {
                queue.offer(startNode);
                component[startNode] = compId;
                int minAnd = -1; // Initialize with -1 (all bits set)
                visited.clear();
                visited.add(startNode);

                while (!queue.isEmpty()) {
                    int node = queue.poll();
                    for (int[] neighborInfo : graph.get(node)) {
                        int neighbor = neighborInfo[0];
                        int weight = neighborInfo[1];
                        if (!visited.contains(neighbor)) {
                            visited.add(neighbor);
                            component[neighbor] = compId;
                            queue.offer(neighbor);
                        }
                        minAnd &= weight;
                    }
                }
                componentMinAnd.put(compId, minAnd);
                compId++;
            }
        }

        int[] result = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int s = queries[i][0];
            int t = queries[i][1];
            if (component[s] != component[t]) {
                result[i] = -1;
            } else {
                result[i] = componentMinAnd.get(component[s]);
            }
        }

        return result;
    }
}