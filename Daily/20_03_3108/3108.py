from collections import defaultdict, deque

class Solution:
    def minimumCost(self, n, edges, queries):

        graph = defaultdict(list)
        for u, v, w in edges:
            graph[u].append((v, w))
            graph[v].append((u, w))


        component = [-1] * n 
        component_min_and = {} 
        comp_id = 0

        def bfs(start):
            queue = deque([start])
            component[start] = comp_id
            min_and = -1 

            visited = set([start])

            while queue:
                node = queue.popleft()
                for neighbor, weight in graph[node]:
                    if neighbor not in visited:
                        visited.add(neighbor)
                        component[neighbor] = comp_id
                        queue.append(neighbor)
                    min_and &= weight  

            component_min_and[comp_id] = min_and


        for node in range(n):
            if component[node] == -1:  
                bfs(node)
                comp_id += 1

        result = []
        for s, t in queries:
            if component[s] != component[t]: 
                result.append(-1)
            else:
                result.append(component_min_and[component[s]])

        return result
