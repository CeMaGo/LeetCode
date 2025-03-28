class MinHeap {
  private heap: [number, number, number][] = []; // [value, row, col]

  push(val: [number, number, number]) {
    this.heap.push(val);
    this.heapifyUp();
  }

  pop(): [number, number, number] | undefined {
    if (this.heap.length === 1) return this.heap.pop();
    const min = this.heap[0];
    this.heap[0] = this.heap.pop()!;
    this.heapifyDown();
    return min;
  }

  peek(): [number, number, number] | null {
    return this.heap.length ? this.heap[0] : null;
  }

  size(): number {
    return this.heap.length;
  }

  private heapifyUp() {
    let index = this.heap.length - 1;
    while (index > 0) {
      let parent = Math.floor((index - 1) / 2);
      if (this.heap[parent][0] <= this.heap[index][0]) break;
      [this.heap[parent], this.heap[index]] = [
        this.heap[index],
        this.heap[parent],
      ];
      index = parent;
    }
  }

  private heapifyDown() {
    let index = 0;
    const length = this.heap.length;
    while (2 * index + 1 < length) {
      let left = 2 * index + 1,
        right = 2 * index + 2;
      let smallest = left;
      if (right < length && this.heap[right][0] < this.heap[left][0]) {
        smallest = right;
      }
      if (this.heap[index][0] <= this.heap[smallest][0]) break;
      [this.heap[index], this.heap[smallest]] = [
        this.heap[smallest],
        this.heap[index],
      ];
      index = smallest;
    }
  }
}

function maxPoints(grid: number[][], queries: number[]): number[] {
  const m = grid.length,
    n = grid[0].length;
  const directions = [
    [0, 1],
    [1, 0],
    [0, -1],
    [-1, 0],
  ];

  // Sort queries with their original index
  let sortedQueries = queries
    .map((val, idx) => [val, idx])
    .sort((a, b) => a[0] - b[0]);
  let result = new Array(queries.length).fill(0);

  let minHeap = new MinHeap();
  let visited = Array.from({ length: m }, () => Array(n).fill(false));

  // Start from the top-left cell
  minHeap.push([grid[0][0], 0, 0]);
  visited[0][0] = true;

  let points = 0;

  // Process queries in increasing order
  for (let [queryVal, queryIdx] of sortedQueries) {
    // Expand reachable cells until the minimum heap value is greater than or equal to queryVal
    while (minHeap.size() > 0 && minHeap.peek()![0] < queryVal) {
      let [_, row, col] = minHeap.pop()!;
      points++;

      for (let [dr, dc] of directions) {
        let nr = row + dr,
          nc = col + dc;
        if (nr >= 0 && nr < m && nc >= 0 && nc < n && !visited[nr][nc]) {
          minHeap.push([grid[nr][nc], nr, nc]);
          visited[nr][nc] = true;
        }
      }
    }
    result[queryIdx] = points;
  }

  return result;
}
