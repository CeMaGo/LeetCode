class Solution:
    def findMissingAndRepeatedValues(self, grid: list[list[int]]) -> list[int]:
        n = len(grid)
        counts = [0] * (n * n + 1)

        for row in grid:
            for num in row:
                counts[num] += 1

        repeating = -1
        missing = -1

        for i in range(1, n * n + 1):
            if counts[i] == 2:
                repeating = i
            elif counts[i] == 0:
                missing = i

        return [repeating, missing]