import java.util.*;

class Solution {
    public int countCompleteComponents(int n, int[][] edges) {
        List<List<Integer>> adj = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        int completeComponents = 0;
        boolean[] visited = new boolean[n];

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                List<Integer> componentNodes = new ArrayList<>();
                Set<Integer> componentEdges = new HashSet<>();
                Queue<Integer> q = new LinkedList<>();

                visited[i] = true;
                componentNodes.add(i);
                q.offer(i);

                while (!q.isEmpty()) {
                    int u = q.poll();
                    for (int v : adj.get(u)) {
                        if (!visited[v]) {
                            visited[v] = true;
                            componentNodes.add(v);
                            q.offer(v);
                        }
                        componentEdges.add(Math.min(u, v) * n + Math.max(u, v)); // Unique edge representation
                    }
                }

                if (isComplete(componentNodes, componentEdges)) {
                    completeComponents++;
                }
            }
        }

        return completeComponents;
    }

    private boolean isComplete(List<Integer> nodes, Set<Integer> edges) {
        int numNodes = nodes.size();
        int expectedEdges = numNodes * (numNodes - 1) / 2;
        return edges.size() == expectedEdges;
    }
}

  