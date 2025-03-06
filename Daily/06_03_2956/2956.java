class Solution {
    public int[] findMissingAndRepeatedValues(int[][] grid) {
        int n = grid.length;
        int[] counts = new int[n * n + 1];

        for (int[] row : grid) {
            for (int num : row) {
                counts[num]++;
            }
        }

        int repeating = -1;
        int missing = -1;

        for (int i = 1; i <= n * n; i++) {
            if (counts[i] == 2) {
                repeating = i;
            } else if (counts[i] == 0) {
                missing = i;
            }
        }

        return new int[]{repeating, missing};
    }
}