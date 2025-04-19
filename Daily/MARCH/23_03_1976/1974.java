import java.util.*;

class Solution {
    public int countPaths( int n, int[][] roads) {
        List<List<Pair>> adj = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] road : roads) {
            int u = road[0];
            int v = road[1];
            int time = road[2];
            adj.get(u).add(new Pair(v, time));
            adj.get(v).add(new Pair(u, time));
        }

        long[] dist = new long[n];
        long[] ways = new long[n];
        Arrays.fill(dist, Long.MAX_VALUE);
        Arrays.fill(ways, 0);

        dist[0] = 0;
        ways[0] = 1;

        PriorityQueue<Pair> pq = new PriorityQueue<>(Comparator.comparingLong(p -> p.time));
        pq.offer(new Pair(0, 0));

        int mod = 100000007;

        while (!pq.isEmpty()) {
        Pair current = pq.poll();
        int u = current.node;
        long d = current.time;

        if ( d > dist[u]) {
            continue;
        }

        for ( Pair neighborPair : adj.get(u)) {
            int v = neighborPair.node;
            long weight = neighborPair.time;
            long newDist = d + weight;

            if (newDist < dist[v]) {
                dist[v] = newDist;
                ways[v] = ways[u];
                pq.offer( new Pair ( v, newDist));
            } else if (newDist == dist[v]) {
                ways[v] = (ways[v] + ways[u]) % mod;
            }
        }
        }
        return (int) ways[n - 1];
    }
    static class Pair {
        int node;
        long time;

        public Pair(int node, long time) {
            this.node = node;
            this.time = time;
        }
    }import java.util.*;

    class Solution {
        public int countPaths(int n, int[][] roads) {
            List<List<Pair>> adj = new ArrayList<>(n);
            for (int i = 0; i < n; i++) {
                adj.add(new ArrayList<>());
            }
            for (int[] road : roads) {
                int u = road[0];
                int v = road[1];
                int time = road[2];
                adj.get(u).add(new Pair(v, time));
                adj.get(v).add(new Pair(u, time));
            }
    
            long[] dist = new long[n];
            long[] ways = new long[n];
            Arrays.fill(dist, Long.MAX_VALUE);
            Arrays.fill(ways, 0);
            dist[0] = 0;
            ways[0] = 1;
    
            PriorityQueue<Pair> pq = new PriorityQueue<>(Comparator.comparingLong(p -> p.time));
            pq.offer(new Pair(0, 0));
    
            int mod = 1000000007;
    
            while (!pq.isEmpty()) {
                Pair current = pq.poll();
                int u = current.node;
                long d = current.time;
    
                if (d > dist[u]) {
                    continue;
                }
    
                for (Pair neighborPair : adj.get(u)) {
                    int v = neighborPair.node;
                    long weight = neighborPair.time;
                    long newDist = d + weight;
    
                    if (newDist < dist[v]) {
                        dist[v] = newDist;
                        ways[v] = ways[u];
                        pq.offer(new Pair(v, newDist));
                    } else if (newDist == dist[v]) {
                        ways[v] = (ways[v] + ways[u]) % mod;
                    }
                }
            }
    
            return (int) ways[n - 1];
        }
    
        static class Pair {
            int node;
            long time;
    
            public Pair(int node, long time) {
                this.node = node;
                this.time = time;
            }
        }
    }
}

    
