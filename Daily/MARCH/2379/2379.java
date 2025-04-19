class Solution {
    public int minimumRecolors(String blocks, int k) {

        int  n = blocks.length();
        int minRecolors = Integer.MAX_VALUE;

        for (int i = 0; i <= n - k; i++) {
            int currentRecolors = 0;

            for (int j = i; j < i + k; j++) {
                if (blocks.charAt(j) == 'W') {
                    currentRecolors++;
                }
            }

            minRecolors = Math.min(minRecolors, currentRecolors);
        }
        return minRecolors;
    }
}