function countPaths(n, roads) {
  const adj = Array(n)
    .fill(null)
    .map(() => []);
  for (const [u, v, time] of roads) {
    adj[u].push([v, time]);
    adj[v].push([u, time]);
  }

  const dist = Array(n).fill(Infinity);
  const ways = Array(n).fill(0);
  dist[0] = 0;
  ways[0] = 1;

  const pq = [[0, 0]]; // [time, node]
  const mod = 10 ** 9 + 7;

  while (pq.length > 0) {
    pq.sort((a, b) => a[0] - b[0]);
    const [d, u] = pq.shift();

    if (d > dist[u]) {
      continue;
    }

    for (const [v, weight] of adj[u]) {
      const newDist = d + weight;

      if (newDist < dist[v]) {
        dist[v] = newDist;
        ways[v] = ways[u];
        pq.push([newDist, v]);
      } else if (newDist === dist[v]) {
        ways[v] = (ways[v] + ways[u]) % mod;
      }
    }
  }

  return ways[n - 1];
}
