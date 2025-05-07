/**
 * @param {number[][]} moveTime
 * @return {number}
 */
var minTimeToReach = function (moveTime) {
  const n = moveTime.length;
  const m = moveTime[0].length;
  const targetRow = n - 1;
  const targetCol = m - 1;

  // Use a priority queue (min-heap) to store cells to visit, prioritized by time.
  const pq = [[0, 0, 0]]; // [time, row, col]
  const visited = new Set();
  visited.add(0 + "," + 0);

  const directions = [
    [0, 1],
    [1, 0],
    [0, -1],
    [-1, 0],
  ]; // Right, Down, Left, Up

  while (pq.length > 0) {
    // Get the cell with the minimum time.  Simulate a min-heap.
    pq.sort((a, b) => a[0] - b[0]);
    const [currentTime, row, col] = pq.shift();

    if (row === targetRow && col === targetCol) {
      return currentTime;
    }

    for (const [dr, dc] of directions) {
      const nextRow = row + dr;
      const nextCol = col + dc;

      if (nextRow >= 0 && nextRow < n && nextCol >= 0 && nextCol < m) {
        const nextTime = Math.max(currentTime, moveTime[nextRow][nextCol]) + 1;
        const nextCellKey = nextRow + "," + nextCol;
        if (!visited.has(nextCellKey)) {
          visited.add(nextCellKey);
          pq.push([nextTime, nextRow, nextCol]);
        }
      }
    }
  }

  return -1; // Should not happen given the problem constraints, but good to have.
};
