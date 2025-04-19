
class Solution:
    def countPaths(self, n: int, roads: List[List[int]]) -> int:
        adj = [[] for _ in range(n)]
        for u, v, time in roads:
            adj[u].append((v, time))
            adj[v].append((u, time))

        dist = [float('inf')] * n
        ways = [0] * n
        dist[0] = 0
        ways[0] = 1

        pq = [(0, 0)]  # (time, node)
        mod = 10**9 + 7

        while pq:
            d, u = heapq.heappop(pq)

            if d > dist[u]:
                continue

            for v, weight in adj[u]:
                new_dist = d + weight

                if new_dist < dist[v]:
                    dist[v] = new_dist
                    ways[v] = ways[u]
                    heapq.heappush(pq, (new_dist, v))
                elif new_dist == dist[v]:
                    ways[v] = (ways[v] + ways[u]) % mod

        return ways[n - 1]